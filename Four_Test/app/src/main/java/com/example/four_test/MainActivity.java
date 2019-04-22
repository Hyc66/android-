package com.example.four_test;


import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private Button addbutton;
    private Button deletebutton;
    private SimpleAdapter adapter;
    private  List<Map<String, Object>> appItems = new ArrayList<Map<String, Object>>();
    private  Map<String, Object> appItem = new HashMap<String, Object>();

    private static String[] applicationNames = new String[]
            { "name", "aderss", "mobal"};
    private static int[] resIds = new int[]
            { R.id.textperson1, R.id.textperson2,R.id.textperson3};
   private ListView lvCommonListView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case 1:
                if (resultCode == 20) {

                    String [] datacopy=data.getStringArrayExtra("massage");
                   // List<Map<String, Object>> appItems = new ArrayList<Map<String, Object>>();
                   // Map<String, Object> appItem = new HashMap<String, Object>();
                    appItem.put("name",datacopy[0]);
                    appItem.put("aderss",datacopy[1]);
                    appItem.put("mobal",datacopy[2]);
                    appItems.add(appItem);


                    /*adapter = new SimpleAdapter(MainActivity.this,
                            appItems, R.layout.person, applicationNames, resIds);
                    adapter.notifyDataSetChanged();*/

                   // lvCommonListView.setAdapter(adapter);

                } else if (resultCode == 21) {
                    Toast toast = Toast.makeText(this, "您取消了操作", Toast.LENGTH_LONG);
                    toast.show();

                }
                break;

            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* appItems=null;
        adapter = new SimpleAdapter(MainActivity.this,
                appItems, R.layout.person, applicationNames, resIds);

        lvCommonListView.setAdapter(adapter);*/

        addbutton=(Button) findViewById(R.id.add_person);
        deletebutton=(Button) findViewById(R.id.delete_person);

        lvCommonListView = (ListView) findViewById(R.id.listperson);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,entry_Activity.class);
                startActivityForResult(intent,1);
               //adapter.notifyDataSetChanged();

            }
        });


        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }

        });

    }




}
