package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements  View.OnClickListener  {

    Button dialNumber, toast ,showLocation , openWebPage , letsGetPro , receivingData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialNumber = findViewById(R.id.dialNumber);
        toast = findViewById(R.id.toast);
        showLocation = findViewById(R.id.showLocation);
        openWebPage = findViewById(R.id.openWebPage);
        letsGetPro= findViewById(R.id.letsGetPro);
        receivingData= findViewById(R.id.receivingData);

        dialNumber.setOnClickListener(this);
        toast.setOnClickListener(this);
        showLocation.setOnClickListener(this);
        openWebPage.setOnClickListener(this);
        letsGetPro.setOnClickListener(this);
        receivingData.setOnClickListener(this);


    }


    @SuppressLint({"NonConstantResourceId", "QueryPermissionsNeeded"})
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId())
        {
            case R.id.dialNumber:
                Uri uri =  Uri.parse("tel:03334347450");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;

            case R.id.toast:
                intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                break;

            case R.id.receivingData:
                intent = new Intent(MainActivity.this, OtherActivity.class);
                intent.putExtra("key", "Nouman");
                startActivity(intent);
                break;


            case R.id.showLocation:
                Uri uri2 =  Uri.parse("geo:31.57057886379325, 74.30959721053932");
                intent = new Intent(Intent.ACTION_VIEW, uri2);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;

            case R.id.openWebPage:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pucit.edu.pk"));
                startActivity(intent);
                break;

            case R.id.viewContent:
                intent = new Intent( Intent.ACTION_VIEW );
                startActivity(intent);
                break;

            case R.id.letsGetPro:
                intent = new Intent("com.example.androidapp.OtherActivity");
                startActivity(intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());



        }
    }
}