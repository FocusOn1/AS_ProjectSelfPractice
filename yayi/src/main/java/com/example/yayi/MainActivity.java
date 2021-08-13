package com.example.yayi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.mylayout);
        YayiView yayi = new YayiView(this);
        yayi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                yayi.bitmapX= motionEvent.getX();
                yayi.bitmapY= motionEvent.getY();
                yayi.invalidate();
                return true;
            }
        });
        frameLayout.addView(yayi);
    }
}