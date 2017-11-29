package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerEx extends AppCompatActivity {
TimePicker timePicker;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener (onTimeChangedListener);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int hour =timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                Toast.makeText(TimePickerEx.this,"你設定的時間:"+hour+":"+minute,Toast.LENGTH_SHORT).show();
            }
        });



   }
    TimePicker.OnTimeChangedListener onTimeChangedListener= new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(TimePickerEx.this,"您選擇的時間是:" + hourOfDay + ":" + minute,Toast.LENGTH_SHORT).show();

        }
    };
}
