package com.example.auser.demouicontrol;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxEx extends AppCompatActivity {

    CheckBox che1,che2,che4,che5,che6,che7;
    Button submit;
    TextView result;
    TextView result2;
    CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        findViews();
        setListener();
    }
    private void findViews(){
        che1=(CheckBox)findViewById(R.id.checkBox1);
        che2=(CheckBox)findViewById(R.id.checkBox2);
        che4=(CheckBox)findViewById(R.id.checkBox4);
        che5=(CheckBox)findViewById(R.id.checkBox5);
        che6=(CheckBox)findViewById(R.id.checkBox6);
        che7=(CheckBox)findViewById(R.id.checkBox7);
        submit=(Button)findViewById(R.id.submit);
        result=(TextView) findViewById(R.id.result);
        result2=(TextView) findViewById(R.id.result2);

    }
    private void setListener(){
        submit.setOnClickListener(btnListener);
        che5.setOnCheckedChangeListener(cbkListener);
        che6.setOnCheckedChangeListener(cbkListener);
        che7.setOnCheckedChangeListener(cbkListener);



    }
    View.OnClickListener btnListener =new View.OnClickListener(){
        @Override
        public void onClick(View view) {
           String text ="您喜歡的顏色是:\n";
            if (che1.isChecked())
                text+=che1.getText()+"`";
            if (che2.isChecked())
                text+=che2.getText()+"`";
            if (che4.isChecked())
                text=che4.getText()+"`";
            if (text.endsWith("`"))
                result.setText(text.substring(0,text.length()-1));
            else
                result.setText(text);


        }

    };
     CheckBox.OnCheckedChangeListener cbkListener = new CheckBox.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(CompoundButton  buttonView, boolean isChecked) {
             String text ="平常的休閒活動是:\n";
             if ((buttonView == che5) && isChecked)
                 text+=che5.getText()+"`";
             if ((buttonView == che6) && isChecked)
                 text+=che6.getText()+"`";
             if ((buttonView == che7) && isChecked)
                 text+=che7.getText()+"`";
             if(text.endsWith("`"))
                 result2.setText(text.substring(0,text.length()-1));
             else
                 result2.setText(text);
         }
     };




}
