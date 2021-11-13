package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    //  https://developer.android.com/guide/components/intents-common
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Toast.makeText(this, "Launching Other Activity", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("key"));
       // Toast.makeText(this, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show();


//        Other way to receive data
//        Bundle bundle = getIntent().getExtras();
//        String str = bundle.getString("key");
//        Toast.makeText(this, str , Toast.LENGTH_SHORT).show();


    }
}