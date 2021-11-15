package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }
}

/*

https://www.youtube.com/watch?v=ylPHePaZ0K8&list=PLUhfM8afLE_Ok-0Lx2v9hfrmbxi3GgsX1&index=5


    height
    widh
    weight

    make layout_height = 0dp and give weight to each item in linear layout will give sequential space
*
*/