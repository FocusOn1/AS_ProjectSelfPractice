package com.example.xialaliebiaokuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * 【方案1】
     * 使用适配器
     * ---PS---
     * 用【1】就不需要写arrays.xml这个文件了
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] ctype =new String[]{
                "全部","娱乐","科技","知识"
        };
        //创建一个adapter对象
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ctype);
        //为适配器设置下拉列表框的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将【适配器】和【下拉列表框】关联起来
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(adapter);//为下拉列表框指定适配器
        //获取选中值
        String str=spinner.getSelectedItem().toString();
        //通过Toast进行输出
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
}
/**
 * 【方案2】
 * 直接在activity_main.xml里敲入下面这段代码，也可以实现：
 * <Spinner
 *        android:layout_width="wrap_content"
 *        android:layout_height="wrap_content"
 *        android:entries="@array/ctype"            //！这句代码不一样
 *        ></Spinner>
 * ---PS---
 * 用【2】需要写arrays.xml这个文件，代码如下：
 * <?xml version="1.0" encoding="utf-8"?>
 * <resources>
 *     <string-array name="ctype">
 *         <item>全部</item>
 *         <item>娱乐</item>
 *         <item>科技</item>
 *         <item>知识</item>
 *     </string-array>
 * </resources>
 */