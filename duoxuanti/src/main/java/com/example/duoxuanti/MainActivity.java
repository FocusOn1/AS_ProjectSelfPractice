package com.example.duoxuanti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox like1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        like1 = findViewById(R.id.like1);
        like1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override   //只监听了like1,另外的没有监听
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(like1.isChecked()){
                    Toast.makeText(MainActivity.this,like1.getText(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}