package com.example.androidapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.List;
import java.util.ArrayList;

public class ListDialog extends DialogFragment {
    List<String> fruits;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Coconut");
        fruits.add("Dates");
        fruits.add("Grapefruit");
        fruits.add("Mango");
        fruits.add("Mulberry");
        fruits.add("Orange");
        fruits.add("Papaya");
        fruits.add("Peach");
        fruits.add("Pear");
        fruits.add("Pineapple");
        fruits.add("Star fruit");
        fruits.add("Tamarind");
        fruits.add("Wood Apple");


        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("Fruits");
        AlertDialog.Builder builder1 = builder.setItems(   fruits.toArray(new String[0]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "I want " + fruits.get(which), Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
