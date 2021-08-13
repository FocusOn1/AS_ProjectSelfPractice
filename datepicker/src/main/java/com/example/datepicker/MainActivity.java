package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    //1.全局变量
    DatePicker datePicker;
    int year,month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.findViewId
        datePicker=findViewById(R.id.datepicker1);
        //3.日期
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
                show(year,monthOfYear,dayOfMonth);  //调用show方法
            }
        });
    }
    //4.定义一个show方法
    private void show(int year,int month,int day){
        String str = year + "年" + (month+1) + "月" + day + "日";
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();  //显示提示框
    }
}