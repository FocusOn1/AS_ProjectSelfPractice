package com.example.xmljavalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final ImageView[] img = new ImageView[4];
    private final int[] imagePath = new int[]{
        R.mipmap.nice1,R.mipmap.nice2,R.mipmap.nice3,R.mipmap.nice4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout = (GridLayout) findViewById(R.id.layout);
        for (int i = 0; i < imagePath.length; i++) {
            img[i] = new ImageView(MainActivity.this);
            img[i].setImageResource(imagePath[i]);
            img[i].setPadding(2,2,2,2);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(550,680);
            img[i].setLayoutParams(params);
            layout.addView(img[i]);
        }
    }
}