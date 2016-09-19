package com.example.wper_smile.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String oldcheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.buttonOne);
        final EditText edt=(EditText)findViewById(R.id.editTextOne);
        final TextView tex1=(TextView)findViewById(R.id.textViewOne);
        final TextView tex2=(TextView)findViewById(R.id.textViewTwo);
        final CheckBox checkBox=(CheckBox)findViewById(R.id.CheckBoxApple);
        final CheckBox checkBoxD=(CheckBox)findViewById(R.id.CheckBoxDog);
        RadioGroup rg=(RadioGroup)findViewById(R.id.RadioGroupSex);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edt.setText("牛奶");
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //根据用户选择的按钮来改变TextView的内容
                String tip=checkedId==R.id.radioButtonMale ?
                        "男人":"女人";
                tex2.setText(tip);
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            /*用if语句来判断选中的状态
            * isChecked()为选中
            * */
            public  void onClick(View v){
                if (checkBox.isChecked()&&!checkBoxD.isChecked())
                    tex1.setText(checkBox.getText());
                if (checkBox.isChecked()&&checkBoxD.isChecked())
                    tex1.setText(checkBox.getText()+"+"+checkBoxD.getText());
                if (!checkBox.isChecked()&&checkBoxD.isChecked())
                    tex1.setText(checkBoxD.getText());
                if (!checkBox.isChecked()&&!checkBoxD.isChecked())
                    tex1.setText("没有选择");
            }
        });
        checkBoxD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxD.isChecked()&&!checkBox.isChecked())
                    tex1.setText(checkBoxD.getText());
                if (checkBox.isChecked()&&checkBoxD.isChecked())
                    tex1.setText(checkBox.getText()+"+"+checkBoxD.getText());
                if (checkBox.isChecked()&&!checkBoxD.isChecked())
                    tex1.setText(checkBox.getText());
                if (!checkBox.isChecked()&&!checkBoxD.isChecked())
                    tex1.setText("没有选择");
            }
        });

    }
}
