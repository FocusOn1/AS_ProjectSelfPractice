package com.example.wanggeshitu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] picture=new int[]{
            R.drawable.nice1,R.drawable.nice2,R.drawable.p1,R.drawable.qiyana,
            R.drawable.sqy,R.drawable.zh,R.drawable.zhanghao
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView=findViewById(R.id.gridview);
        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < picture.length; i++) {
            Map<String,Object> map =new HashMap<String,Object>();
            map.put("image",picture[i]);
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter=    //适配器
                new SimpleAdapter(this,listitem,R.layout.cell,new String[]{"image"},new int[]{R.id.image});
        gridView.setAdapter(simpleAdapter);//给网格视图配一个适配器
    }
}