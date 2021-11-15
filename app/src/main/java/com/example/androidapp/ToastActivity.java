package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    Button btnCustomToast ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnCustomToast = findViewById(R.id.btnCustomToast);

        btnCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });
    }

    public void showToast()
    {
        /*
        * 1) res -> right click on layout -> new -> layout resource file ( toast_layout )
        * 2) drawables ->  new -> vector asset
        *
        * */
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.root_toast));

        //  dynamically add toast text and image
        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);
        toastText.setText("This is Custom Toast");
        toastImage.setImageResource(R.drawable.ic_toast_icon);


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}