package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class UI_Widgets extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton male, female;
    LinearLayout linearLayout ;
    ToggleButton toggleButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_widgets);

        radioGroup = findViewById(R.id.gender);
        male =findViewById(R.id.radioButtonMale);
        female =findViewById(R.id.radioButtonFemale);
        linearLayout = findViewById(R.id.layout12);
        toggleButton = findViewById(R.id.toggleButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonMale:
                        Toast.makeText(UI_Widgets.this, "male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonFemale:
                        Toast.makeText(UI_Widgets.this, "female", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked())
                {
                    linearLayout.setBackgroundColor(Color.CYAN);
                }
                else
                {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });
    }
}