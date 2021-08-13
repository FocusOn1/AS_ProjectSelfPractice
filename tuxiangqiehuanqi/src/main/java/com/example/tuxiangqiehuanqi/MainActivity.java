package com.example.tuxiangqiehuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSwitcher is = findViewById(R.id.imageSwitcher);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        is.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));//设置淡出效果
        is.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));//设置淡入效果
        is.setFactory(new ViewSwitcher.ViewFactory() {//视图工厂
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.nice2);
                return imageView;
            }
        });
        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageSwitcher)view).setImageResource(R.drawable.zhanghao);
            }
        });
    }
}