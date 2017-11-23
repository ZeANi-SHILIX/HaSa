package com.example.hasa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.*;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.Manifest;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ResourceBundle;

//import static android.widget.Toast.LENGTH_SHORT;
//import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {
    public static int sumStatic = 0;
    public static ArrayList<String> itemhistory;
    int[] value_shekels= new int[3];
    String value_name = "sp_value_shekel";
    //boolean change_content_view = true;


    public void readFile(){
        SharedPreferences sharedPreferences = getSharedPreferences(this.value_name,Context.MODE_PRIVATE);
        int[] defaultValue = {9,8,12};
        this.value_shekels[0] =sharedPreferences.getInt("value_1",defaultValue[0]);
        this.value_shekels[1] =sharedPreferences.getInt("value_2",defaultValue[1]);
        this.value_shekels[2] =sharedPreferences.getInt("value_3",defaultValue[2]);
        //toast
    }
    public void saveFile(){
        SharedPreferences sharedPreferences = getSharedPreferences(value_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("value_1",value_shekels[0]);
        editor.putInt("value_2",value_shekels[1]);
        editor.putInt("value_3",value_shekels[2]);
        editor.commit();
    }

    // add 1 to hasa
    public  void addHasa(View v){
        EditText a = (EditText) findViewById(R.id.editText_hasa);
        int z =NumIs(a.getText().toString())+1;
        a.setText(z+"");

        //add 9(def) to sumStatic
        sumStatic+=value_shekels[0];
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //add 1 to yerakot
    public void addOther(View v){
        EditText a = (EditText) findViewById(R.id.editText_other);
        a.setText(NumIs(a.getText().toString()) +1+"");

        //add 8(def) to sumStatic
        sumStatic+=value_shekels[1];
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //add 1 to potato
    public void addPotato(View v){
        EditText a = (EditText) findViewById(R.id.editText_potato);
        a.setText(NumIs(a.getText().toString()) +1+"");

        //add 12(def) to sumStatic
        sumStatic+=value_shekels[2];
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

     // minus 1 to hasa
    public  void minusHasa(View v){
        EditText a = (EditText) findViewById(R.id.editText_hasa);
        int z =NumIs(a.getText().toString())-1;
        if (z<=0)
            a.setText("");
        else
            a.setText(z+"");

        //minus 9 to sumStatic
        sumStatic-=value_shekels[0];
        if(sumStatic<=0)
            sumStatic=0;
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //minus 1 to other
    public void minusOther(View v){
        EditText a = (EditText) findViewById(R.id.editText_other);
        int z =NumIs(a.getText().toString())-1;
        if (z<=0)
            a.setText("");
        else
            a.setText(z+"");

        //minus 8 to sumStatic
        sumStatic-=value_shekels[1];
        if(sumStatic<=0)
            sumStatic=0;
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //minus 1 to potato
    public void minusPotato(View v){
        EditText a = (EditText) findViewById(R.id.editText_potato);
        int z =NumIs(a.getText().toString())-1;
        if (z<=0)
            a.setText("");
        else
            a.setText(z+"");

        //minus 12 to sumStatic
        sumStatic-=value_shekels[2];
        if(sumStatic<=0)
            sumStatic=0;
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //clear EditTexts
    public void clear(View v) {
        EditText editText1 = (EditText) findViewById(R.id.editText_hasa);
        EditText editText2 = (EditText) findViewById(R.id.editText_other);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText_potato);
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");

        sumStatic=0;
        TextView Text = (TextView) findViewById(R.id.sum_static);
        Text.setText(sumStatic+"");
    }

    //app not founded
    public void NoApp(){
        Toast.makeText(this,"The App NOT found.", Toast.LENGTH_SHORT).show();
    }

    //convert string to int
    public static int NumIs(String x){

        if (x.length()>0){
            if (x.length()==1)
                return x.charAt(0)-48;
            if (x.length()==2)
                return x.charAt(0)*10+x.charAt(1)-528;
            return (x.charAt(0)-48)*100+x.charAt(1)*10+x.charAt(2)-528;
        }
        return 0;
    }

    //save
    public boolean saveArray() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEdit1 = sp.edit();
    /* sKey is an array */
        mEdit1.putInt("Status_size", itemhistory.size());

        for(int i=0;i<itemhistory.size();i++)
        {
            mEdit1.remove("Status_" + i);
            mEdit1.putString("Status_" + i, itemhistory.get(i));
        }

        return mEdit1.commit();
    }

    public static void loadArray(Context mContext)
    {
        SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);
        itemhistory.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for(int i=0;i<size;i++)
        {
            itemhistory.add(mSharedPreference1.getString("Status_" + i, null));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumStatic = 0;




       //menu on textview "hasa".
        final TextView btnpup_hasa;
        btnpup_hasa = (TextView) findViewById(R.id.textView);
        btnpup_hasa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popupMenu_ha = new PopupMenu(MainActivity.this,btnpup_hasa);
                popupMenu_ha.getMenuInflater().inflate(R.menu.menu_main,popupMenu_ha.getMenu());
                popupMenu_ha.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        EditText ha = (EditText) findViewById(R.id.editText_hasa);
                        if (item.getTitle().equals("1")){
                            ha.setText(""+1);
                        }else if (item.getTitle().equals("2")){
                            ha.setText("2");
                        }else if (item.getTitle().equals("3")){
                            ha.setText("3");
                        }else if (item.getTitle().equals("4")){
                            ha.setText("4");
                        }else if (item.getTitle().equals("5")){
                            ha.setText("5");
                        }
                        return true;
                    }
                });
                popupMenu_ha.show();
            }
        });
        //menu other.
        final TextView btnpup_other;
        btnpup_other = (TextView) findViewById(R.id.textView2);
        btnpup_other.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popupMenu_oth = new PopupMenu(MainActivity.this,btnpup_other);
                popupMenu_oth.getMenuInflater().inflate(R.menu.menu_main,popupMenu_oth.getMenu());
                popupMenu_oth.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        EditText oth = (EditText) findViewById(R.id.editText_other);
                        if (item.getTitle().equals("1")){
                            oth.setText(""+1);
                        }else if (item.getTitle().equals("2")){
                            oth.setText("2");
                        }else if (item.getTitle().equals("3")){
                            oth.setText("3");
                        }else if (item.getTitle().equals("4")){
                            oth.setText("4");
                        }else if (item.getTitle().equals("5")){
                            oth.setText("5");
                        }
                        return true;
                    }
                });
                popupMenu_oth.show();
            }
        });
        // menu potato.
        final TextView btnpup_potato;
        btnpup_potato = (TextView) findViewById(R.id.textView5);
        btnpup_potato.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popupMenu_po = new PopupMenu(MainActivity.this,btnpup_potato);
                popupMenu_po.getMenuInflater().inflate(R.menu.menu_main,popupMenu_po.getMenu());
                popupMenu_po.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        EditText po = (EditText) findViewById(R.id.editText_potato);
                        if (item.getTitle().equals("1")){
                            po.setText(""+1);
                        }else if (item.getTitle().equals("2")){
                            po.setText("2");
                        }else if (item.getTitle().equals("3")){
                            po.setText("3");
                        }else if (item.getTitle().equals("4")){
                            po.setText("4");
                        }else if (item.getTitle().equals("5")){
                            po.setText("5");
                        }
                        return true;
                    }
                });
                popupMenu_po.show();
            }
        });


        //history list
        ListView listView = (ListView) findViewById(R.id.list);
        itemhistory = new ArrayList<String>();
        loadArray(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, itemhistory);
        listView.setAdapter(adapter);


        //value_shekels read.
        readFile();
        saveFile();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sam = 0, as;
                EditText a1 = (EditText) findViewById(R.id.editText_hasa);
                String zhasa = a1.getText().toString();
                as = NumIs(zhasa);
                sam += as * value_shekels[0];

                EditText a2 = (EditText) findViewById(R.id.editText_other);
                String zother = a2.getText().toString();
                as = NumIs(zother);
                sam += as * value_shekels[1];

                EditText a3 = (EditText) findViewById(R.id.editText3);
                String za = a3.getText().toString();
                as = NumIs(za);
                sam += as;

                EditText a4 = (EditText) findViewById(R.id.editText4);
                za = a4.getText().toString();
                as = NumIs(za);
                sam = sam - as;

                EditText a5 = (EditText) findViewById(R.id.editText_potato);
                String zpotato = a5.getText().toString();
                as = NumIs(zpotato);
                sam += as * value_shekels[2];

                //final text (to send)
                final String BodyOF = " לתשלום " +"₪"+ sam ;


                //add history
                if(!zhasa.equals("")||!zother.equals("")||!zpotato.equals("")){
                    String addvalue ="";
                    if (!zhasa.equals(""))
                        addvalue+=zhasa+" חסה, ";
                    if (!zother.equals(""))
                        addvalue+=zother+" ירקות, ";
                    if (!zpotato.equals(""))
                        addvalue+=zpotato+" עגבניות. ";
                    addvalue+=BodyOF;
                    //check double
                    if (!itemhistory.contains(addvalue)) {
                        itemhistory.remove(addvalue);
                        itemhistory.add(addvalue);
                    }
                    //save list
                    saveArray();
                }


                //long press on button to send with whatsapp:
                Button lo = (Button) findViewById(R.id.button);
                lo.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {

                        try {
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_TEXT, BodyOF);
                        share.setPackage("com.whatsapp");
                        startActivity(share); }
                        catch (Exception e){
                            NoApp();
                        }
                        return true;
                    }
                });
                //end.

                AlertDialog sms_body = new AlertDialog.Builder(MainActivity.this)
                        .setTitle(" לתשלום " + sam)
                        .setMessage("לשלוח בSMS/WhatsApp?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                Intent sendIntent = new Intent();
                                sendIntent.setAction(Intent.ACTION_SEND);
                                sendIntent.putExtra(Intent.EXTRA_TEXT, BodyOF);
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_menu_share)
                        .show();



            }


        }
                /*
                // ListView Item Click Listener
                listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        // ListView Clicked item index
                        int itemPosition     = position;

                        // ListView Clicked item value
                        String  itemValue    = (String) listView.getItemAtPosition(position);

                        // Show Alert
                        Toast.makeText(getApplicationContext(),
                                "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                                .show();

                    }
                   */

        );







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_start,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.Activ1:
                final Intent intent = new Intent(this ,Main2Activity.class);
                startActivity(intent);
                return true;
            case R.id.Activ2:
                final Intent intent_ch = new Intent(this ,ActivityChangeValue.class);
                startActivity(intent_ch);
                return true;
            case R.id.Activ3:
                /*
                //change contentView
                //true is Main, false is test
                if(change_content_view){
                    setContentView(R.layout.test1);
                }else {
                    setContentView(R.layout.activity_main);
                }
                change_content_view=!change_content_view;
                */

                final Intent intent_1 = new Intent(this ,MainActivity.class);
                startActivity(intent_1);
                return true;
            default:
                return super.onOptionsItemSelected(item);

       }
    }
}
