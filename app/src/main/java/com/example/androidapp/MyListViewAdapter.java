package com.example.androidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListViewAdapter extends ArrayAdapter  {

    Activity context;
    ArrayList<String> names;
    Button showDetailBtn;

    public MyListViewAdapter(Activity context, ArrayList<String> names) {
        super(context, R.layout.customized_listview, names);
        this.context = context;
        this.names = names;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=  context.getLayoutInflater();
        View view = inflater.inflate( R.layout.customized_listview, null,true);

        TextView nameText =  view.findViewById (R.id.nameText);
        nameText.setText(names.get(position));

        showDetailBtn =    view.findViewById(R.id.showDetailBtn);
        showDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context , ListViewItemDetailActivity.class );
                intent.putExtra("name", names.get(position).toString() );
                context.startActivity(intent);
            }
        });

        return view;
    }
}
