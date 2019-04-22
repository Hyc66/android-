package com.example.four_test;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class entry_Activity extends Activity {

    private Button determine;
    private Button cancel;
    private EditText editname;
    private EditText editadress;
    private EditText editmobel;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        determine=(Button) findViewById(R.id.determine);
        cancel=(Button) findViewById(R.id.cancel);
        editname=(EditText) findViewById(R.id.editname);
         editadress=(EditText) findViewById(R.id.editadress);
         editmobel=(EditText) findViewById(R.id.editmobel);


        determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                //
                //List<Map<String, Object>> appItems = new ArrayList<Map<String, Object>>();
               // Map<String, Object> appItem = new HashMap<String, Object>();

                String [] data={editname.getText().toString(),editadress.getText().toString(),editmobel.getText().toString()};

               /* appItem.put("name",data[0]);
                appItem.put("aderss",data[1]);
                appItem.put("mobal",data[2]);
                appItems.add(appItem);
*/
                intent.putExtra("massage", data);
                setResult(20,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setResult(21);
                finish();
            }
        });

    }
}