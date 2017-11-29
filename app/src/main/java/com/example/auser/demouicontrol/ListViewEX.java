package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewEX extends AppCompatActivity {
ListView listView;
    String[] arrays={"網路概論","網路通訊實驗","通訊概論"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ex);
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,arrays);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListViewEX.this,"你的選擇是:"+(position+1)+((CheckedTextView)view).getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
