package com.example.auser.demouicontrol;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerEX extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ex);
        spinner=(Spinner)findViewById(R.id.spinner);
        setSpinner(spinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner_menu, menu);
        MenuItem item = menu.findItem(R.id.actionbar_spinner);
        Spinner ab_spinner = (Spinner) MenuItemCompat.getActionView(item);
        setSpinner(ab_spinner);
        return super.onCreateOptionsMenu(menu);
    }
    void setSpinner(Spinner spinner) {
        adapter =ArrayAdapter.createFromResource(this,R.array.cards,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.select_dialog_multichoice);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerEX.this,"第"+(position+1)+"向",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
