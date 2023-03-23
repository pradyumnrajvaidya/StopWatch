package com.example.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{
      private TextView textview;
     private Button start,pause,stop,resume;
      int time = 0;
      boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        resume = findViewById(R.id.resume);
    }
    public void start(View view){
        startTimer();
        flag = true;
    }
    public void pause(View view){
        flag = false;
    }
    public void stop(View view){
        flag=false;
        time = 0;
    }
    public void resume(View view){

            flag = true;
    }
    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int millisecond = time % 100;
                int second = (time % 6000) / 100;
                int minuet = (time % 360000)/ 6000;
                int hour = time / 360000;
                String stringFormat = String.format(Locale.getDefault(),"%02d:%02d:%02d:%02d", hour,minuet,second,millisecond);
                textview.setText(stringFormat);
                handler.postDelayed(this, 100);
                if(flag) {
                    time++;
                }
            }
        };
        handler.post(runnable);
    }

}