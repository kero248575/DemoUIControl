package com.example.auser.demouicontrol;

import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonEx extends AppCompatActivity {
    RadioGroup rg1,rg2,rg3;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        findViews();
        setListener();
    }
    private void findViews(){
        rg1=(RadioGroup)findViewById(R.id.radioGroup);
        rg2=(RadioGroup)findViewById(R.id.radioGroup2);
        rg3=(RadioGroup)findViewById(R.id.radioGroup3);
        submit=(Button)findViewById(R.id.submit);
        result=(TextView) findViewById(R.id.result);

    }
    private void setListener(){
        submit.setOnClickListener(btnListener);
        rg1.setOnCheckedChangeListener(rgListener);
        rg2.setOnCheckedChangeListener(rgListener);
        rg3.setOnCheckedChangeListener(rgListener);

    }
    View.OnClickListener btnListener =new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            RadioButton rBtn=(RadioButton)findViewById(rg1.getCheckedRadioButtonId());
            String text="您對此次用餐感到?"+rBtn.getText();
            result.setText(text);
        }
    };
    RadioGroup.OnCheckedChangeListener rgListener =new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            int resId =group.getId();
            String groupName =getResources().getResourceEntryName(resId);
            String itemName =getResources().getResourceEntryName(checkedId);
            switch (resId){
                case R.id.radioGroup:


                case R.id.radioGroup2:
                case R.id.radioGroup3:
                    Toast.makeText(RadioButtonEx.this,groupName+":"+itemName,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };



}
