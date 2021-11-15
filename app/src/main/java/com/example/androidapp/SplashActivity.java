package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();  //  hide toolbar

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent( SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        thread.start();


    }
}

/*
* relative layout attributes:

center    ---------
parent    -------   for textview bottom center

textsize      18sp

textstyle    bold

margin   20dp

* */