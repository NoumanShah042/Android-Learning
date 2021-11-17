package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListViewItemDetailActivity extends AppCompatActivity {

    TextView nameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item_detail);

        nameTextView = findViewById(R.id.nameTextView);
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra("name"));


    }
}