package com.example.jindutiao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private ProgressBar progressBar;
        private int mProgress=0;
        private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);//设置全屏显示
        progressBar=findViewById(R.id.progressBar);
        mHandler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what==0x111){
                    progressBar.setProgress(mProgress);
                }else {
                    Toast.makeText(MainActivity.this,"耗时操作已完成",Toast.LENGTH_SHORT).show();//弹出对话框
                    progressBar.setVisibility(View.GONE);//设置进度条不显示
                }
            }
        };
        new Thread(new Runnable() { //线程
            @Override
            public void run() {
                while (true) {
                    mProgress = doWork();
                    Message m =new Message();
                    if(mProgress<100){
                        m.what=0x111;
                        mHandler.sendMessage(m);
                    }else {
                        m.what=0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWork(){   //模拟耗时操作
                mProgress+=Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();

    }
}