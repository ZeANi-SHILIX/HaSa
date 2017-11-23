package com.example.hasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

public class Main2Activity extends AppCompatActivity {
    String[] ans2 = {"1","2","3","4"};

    public static String[] Callculeter(String in){
        if (in == null) {
            String[] sd ={"2","3"};
            return sd;
        }
        String[] out2 = {""};
        out2 = in.split(",");
        int le = out2.length;
        String[] out = new String[le*2];

        int le2 = le*2,round=0;
        for(int i=0; i<le2 ;i=i+2,round++){
            String[] p = out2[round].split(" ", 2);
            out[i] = p[0];
            //out[i+1] = p[1];
        }

        return out;
    }

    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.putText);
        String as1 = editText.getText().toString();
        String[] ans = {""};
        String a1="";


        /*
        switch (editText.getId()) {
            case R.id.putText:
                a1 =(String) editText.getText();
                break;
        }
        */
        //String a1 =(String) editText.getText().toString();
        if (a1!=null)
            ans = Callculeter(a1);



        for (int i =0;i<ans.length;i++)
            ans2[i]=ans[i];

        GridView gridView = (GridView) findViewById(R.id.grid);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,ans2);
        gridView.setAdapter(adapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);






        /*
        findViewById(R.id.bbt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText6);
                String[] ans = Callculeter(editText.getText().toString());

                GridView gridView = (GridView) findViewById(R.id.grid);
                //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,ans);
               // gridView.setAdapter(adapter);
            }
        });
           */





    }
}
