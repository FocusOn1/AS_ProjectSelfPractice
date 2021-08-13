package com.example.tuxiangqiehuanqi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int[] arrayPicture=new int[]{
        R.drawable.nice1,R.drawable.nice2,
    };
    private ImageSwitcher imageSwitcher;
    private int index;
    private float touchDownX;
    private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW);//设置全屏显示
        //设置图片工厂
        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPicture[index]);
                return imageView;
            }
        });
        //触摸事件监听器---目前slide_in_left.xml和slide_in_right.xml还不是左右顺畅切图的代码，后续持续改进！
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    touchDownX=motionEvent.getX();
                    return true;
                }else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    touchUpX=motionEvent.getX();
                    if(touchUpX-touchDownX>100){
                        index=index==0?arrayPicture.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if(touchDownX-touchUpX>100){
                        index=index==arrayPicture.length-1?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }
                    return true;
                }
                return false;
            }
        });

    }
}