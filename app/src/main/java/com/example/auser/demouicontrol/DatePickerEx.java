package com.example.auser.demouicontrol;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerEx extends AppCompatActivity {
DatePicker datepicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        datepicker=(DatePicker)findViewById(R.id.datePicker);
        Calendar calendar =Calendar.getInstance();
        datepicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),onDateChangedListener);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int year=datepicker.getYear();
                int month=datepicker.getMonth();
                int day=datepicker.getDayOfMonth();
                Toast.makeText(DatePickerEx.this,"您選擇的日期:"+year+"/"+month+"/"+day,Toast.LENGTH_LONG).show();


            }
        });


    }
    DatePicker.OnDateChangedListener onDateChangedListener=new  DatePicker.OnDateChangedListener(){
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Toast.makeText(DatePickerEx.this,"您選擇的日期:"+year+"/"+monthOfYear+"/"+dayOfMonth,Toast.LENGTH_LONG).show();
        }
    };
}
