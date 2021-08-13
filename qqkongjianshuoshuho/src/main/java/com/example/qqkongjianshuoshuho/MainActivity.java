package com.example.qqkongjianshuoshuho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
//为普通按钮添加单击事件监听器（2个方法）：
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(i);
                Toast.makeText(MainActivity.this,"选择："+rb.getText(),Toast.LENGTH_LONG).show();
            }
        });
        //①匿名内部类作为单击事件监听器
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "单击了按钮1", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //②通过onClick属性实现
    public void myClick(View view){
        Toast.makeText(MainActivity.this,"单击了按钮2",Toast.LENGTH_LONG).show();
    }
}