package com.example.tuodongtiao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image);
        seekBar=findViewById(R.id.seekBar);
        RatingBar ratingBar=findViewById(R.id.ratingBtar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//进度拖动的方法
                image.setImageAlpha(i);//改变图片的透明度
                Toast.makeText(MainActivity.this,"进度改变："+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//开始触摸的方法
                Toast.makeText(MainActivity.this,"开始触摸",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {//停止触摸的方法
                Toast.makeText(MainActivity.this,"停止触摸",Toast.LENGTH_SHORT).show();
            }
        });
    //星星
        String rating=String.valueOf(ratingBar.getRating());
        Toast.makeText(MainActivity.this,"Rating:"+rating,Toast.LENGTH_SHORT).show();
        String stepSize=String.valueOf(ratingBar.getStepSize());
        Toast.makeText(MainActivity.this,"stepSize:"+stepSize,Toast.LENGTH_SHORT).show();
        String progress=String.valueOf(ratingBar.getProgress());
        Toast.makeText(MainActivity.this,"Progress:"+progress,Toast.LENGTH_SHORT).show();
    }
}