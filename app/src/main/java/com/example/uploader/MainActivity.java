package com.example.uploader;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar1, progressBar2;
    Button start,stop,upload;
    int progress=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar1 = findViewById(R.id.progressBar);
        progressBar2 =findViewById(R.id.progressBar2);
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        upload = findViewById(R.id.button3);
        progressBar1.setVisibility(View.GONE);

    }
    public void start(View view){
        progressBar1.setVisibility(View.VISIBLE);


    }

    public void stop(View view){
        progressBar1.setVisibility(View.GONE);


    }
    public void upload(View view){
        fakepogress(progress);


    }
    public void fakepogress(final  int progress){

        progressBar2.setProgress(progress);

        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                fakepogress(progress +25);

            }
        });


        thread.start();
    }
}