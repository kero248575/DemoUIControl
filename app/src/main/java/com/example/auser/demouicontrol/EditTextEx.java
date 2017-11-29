package com.example.auser.demouicontrol;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditTextEx extends AppCompatActivity {
    private static final String PREF_FILE = "settings";
    private EditText etAccount;
    private EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        findView();
        restore();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void findView(){
        etAccount=(EditText)findViewById(R.id.account);
        etPassword=(EditText)findViewById(R.id.password);


    }
    private void restore(){
        SharedPreferences settings=getSharedPreferences(PREF_FILE,0);
        String account = settings.getString("etAccount","");
        String password = settings.getString("etPassword","");
        if (!account.equals(""))
            etAccount.setText(account);
        if (!account.equals(""))
            etPassword.setText(password);




    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings=getSharedPreferences(PREF_FILE,0);
        settings.edit().putString("etAccount",etAccount.getText().toString()).commit();
        settings.edit().putString("etAccount",etPassword.getText().toString()).commit();
    }

}
