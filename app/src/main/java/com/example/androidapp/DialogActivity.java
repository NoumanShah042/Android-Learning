package com.example.androidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    Button showDialog;
    Button listDialog;
    Button checkBoxDialog;
    Button radioButtonDialog;
    Button customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        showDialog = findViewById(R.id.showDialog);
        listDialog = findViewById(R.id.listDialog);
        checkBoxDialog = findViewById(R.id.checkBoxDialog);
        radioButtonDialog = findViewById(R.id.radioButtonDialog);
        customDialog = findViewById(R.id.customDialog);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 new ExampleDialog().show(getSupportFragmentManager(),"MyExampleDialog");
            }
        });

        listDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ListDialog().show(getSupportFragmentManager(),"MyListDialog");
            }
        });
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(DialogActivity.this)
                //  right click ( res->drawables) -> new and select vector asset
                .setIcon(R.drawable.ic_warning)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Click Yes to close this app", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}

/*
Dialog components:
* icon
* title
* message
* positive button
* negative button
* neutral button
*
* https://www.youtube.com/watch?v=ARezg1D9Zd0     for custom dialog
* */