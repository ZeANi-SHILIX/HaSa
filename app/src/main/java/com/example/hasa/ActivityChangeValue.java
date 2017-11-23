package com.example.hasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityChangeValue  extends MainActivity {

    //add
    public void ch_addhasa(){
        TextView textView = (TextView) findViewById(R.id.ch_text_hasa);
        value_shekels[0]+=1;
        textView.setText(value_shekels[0]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }
    public void ch_addother(){
        TextView textView = (TextView) findViewById(R.id.ch_text_other);
        value_shekels[1]+=1;
        textView.setText(value_shekels[1]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }
    public void ch_addpotato(){
        TextView textView = (TextView) findViewById(R.id.ch_text_potato);
        value_shekels[2]+=1;
        textView.setText(value_shekels[2]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }
    //minus
    public void ch_minushasa(){
        TextView textView = (TextView) findViewById(R.id.ch_text_hasa);
        value_shekels[0]-=1;
        textView.setText(value_shekels[0]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }
    public void ch_minusother(){
        TextView textView = (TextView) findViewById(R.id.ch_text_other);
        value_shekels[1]-=1;
        textView.setText(value_shekels[1]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }
    public void ch_minuspotato(){
        TextView textView = (TextView) findViewById(R.id.ch_text_potato);
        value_shekels[2]-=1;
        textView.setText(value_shekels[2]+"");
        saveFile();
        Toast.makeText(this,"השינוי נשמר.",Toast.LENGTH_SHORT).show();
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_value);

        //read value.
        readFile();
        TextView textView_hasa = (TextView) findViewById(R.id.ch_text_hasa);
        textView_hasa.setText(value_shekels[0]+"");
        TextView textView_other = (TextView) findViewById(R.id.ch_text_other);
        textView_other.setText(value_shekels[1]+"");
        TextView textView_potato = (TextView) findViewById(R.id.ch_text_potato);
        textView_potato.setText(value_shekels[2]+"");

        //add ********************************************************************************
        Button button1 = (Button) findViewById(R.id.ch_button1);;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_addhasa();
            }
        });
        Button button3 = (Button) findViewById(R.id.ch_button3);;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_addother();
            }
        });
        Button button5 = (Button) findViewById(R.id.ch_button5);;
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_addpotato();
            }
        });

        //minus ********************************************************************************
        Button button2 = (Button) findViewById(R.id.ch_button2);;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_minushasa();
            }
        });
        Button button4 = (Button) findViewById(R.id.ch_button4);;
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_minusother();
            }
        });
        Button button6 = (Button) findViewById(R.id.ch_button6);;
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch_minuspotato();
            }
        });






    }
}
