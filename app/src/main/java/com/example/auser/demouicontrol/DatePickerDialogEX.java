package com.example.auser.demouicontrol;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerDialogEX extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepickerdialog);
        Calendar calendar =Calendar.getInstance();
        DatePickerDialog datePickerDialog =new DatePickerDialog(
                this,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
    DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            Toast.makeText(DatePickerDialogEX.this,"您選擇的日期:"+year+"/"+month+"/"+dayOfMonth,Toast.LENGTH_LONG).show();
        }
    };
}
