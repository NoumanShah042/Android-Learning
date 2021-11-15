package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    EditText editText ;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

//                String n = s.toString() +" "+ start +" "+before+" "+count;   //   noum 0 3 4
//                Toast.makeText(getApplicationContext(),n , Toast.LENGTH_SHORT).show();
                String name = editText.getText().toString().trim();
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString().trim();
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}