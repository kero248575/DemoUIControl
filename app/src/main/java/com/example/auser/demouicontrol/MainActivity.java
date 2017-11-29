package com.example.auser.demouicontrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    Class<?>[] activityClasses = {
            CheckBoxEx.class,
            DatePickerDialogEX.class,
            EditTextEx.class,
            ListViewEX.class,
            ProgressBarEx.class,
            RadioButtonEx.class,
            RatingBarEx.class,
            TimePickerEx.class,
            ToggleButtonEX.class,
            SpinnerEX.class,
            GridViewEX.class,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getActivityNames());
        listView.setAdapter(adapter);
        setListeners();


        }
    String[] getActivityNames () {
        String[] activityNames = new String[activityClasses.length];
        for (int i = 0; i < activityClasses.length; i++)
            activityNames[i] = activityClasses[i].getSimpleName();
        return activityNames;
    }
    AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(MainActivity.this,activityClasses[position]);
            startActivity(intent);
        }
    };
    void setListeners(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,activityClasses[i]);

                startActivity(intent);
            }
        });
    }



}
