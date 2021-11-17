package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView friendsListView;
    ArrayList<String> friends;
    MyListViewAdapter  arrayAdapter;
    Button addBtn;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        friendsListView = findViewById(R.id.friendsList);
        addBtn = findViewById(R.id.addBtn);
        editText1 = findViewById(R.id.editText1);

        friends = new ArrayList<String>();
//        friends.add("Ali");
//        friends.add("Humza");
//        friends.add("Syed");
//        friends.add("Zeeshan");
//        friends.add("Fatima");

        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends);
        arrayAdapter = new MyListViewAdapter(this , friends);
        friendsListView.setAdapter(arrayAdapter);


//        //     setOnItemClickListener to delete that item ----------------------------------------------------
//        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                String text = "Item "+position + ", " + ((TextView)view).getText().toString();
////                String text = "Item "+position + ", " + friends.get(position);
////                Toast.makeText(ListViewActivity.this, text, Toast.LENGTH_SHORT).show();
//
//                //  making dialog to delete item on click ---------------------------------
//                new AlertDialog.Builder(ListViewActivity.this)
//                        .setTitle("Delete Record")
//                        .setMessage("Do you really want to delete this task!").
//                        setIcon(R.drawable.ic_warning)
//                        .setCancelable(false)
//                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                friends.remove(position);
//                                arrayAdapter.notifyDataSetChanged();
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .show();
//                //  --------------------------------------------------------------------------
//            }
//        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText1.getText().toString().trim();
                if (!text.matches("")) {
                    friends.add(text);
                    arrayAdapter.notifyDataSetChanged();
                    editText1.setText("");
                } else {
                    Toast.makeText(ListViewActivity.this, "Enter Friend Name", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}

/*

https://www.youtube.com/watch?v=geWi5v7_Zsc

https://www.tutorialspoint.com/android/android_list_view.htm     notes on listView


   Designing List View:
*  1) add listView
*  2) set its layout_width to wrap content
*  3) for now , set layout_height to some dp
*  4)  Now we can align it vertically
*  5) so drag it to set it vertically
*  6) at last set its  layout_height to wrap content

ListView:
Android ListView is a view which groups several items and display them in vertical scrollable list.
The list items are automatically inserted to the list using an Adapter that pulls content from a
 source such as an array or database.

adapter:
An adapter actually bridges between UI components and the data source that fill data into UI
Component. Adapter holds the data and send the data to adapter view, the view can takes the data
from adapter view and shows the data on different views like as spinner, list view, grid view etc.

The ListView and GridView are subclasses of AdapterView and they can be populated by binding them
to an Adapter, which retrieves data from an external source and creates a View that represents each
 data entry.

Android provides several subclasses of Adapter that are useful for retrieving different kinds of
data and building views for an AdapterView ( i.e. ListView or GridView).
The common adapters are
ArrayAdapter,
Base Adapter,
CursorAdapter,
SimpleCursorAdapter,
SpinnerAdapter and
WrapperListAdapter.

**********************************************

ArrayAdapter
You can use this adapter when your data source is an array.
By default, ArrayAdapter creates a view for each array item by calling toString() on each item
and placing the contents in a TextView.

ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,friends );

Here are arguments for this constructor −
First argument this is the application context. Most of the case, keep it this.
Second argument will be layout defined in XML file and having TextView for each string in the array.
( we can use built in android.R.layout )
Final argument is an array of strings which will be populated in the text view.
***********

hold ctrl and press on simple_list_item_1 to see xml file

***********************************************

Make Customized ListView :

1) make customized ListView item design in an XML file
2) make adapter in separate class  ->>>>     public class MyListViewAdapter extends ArrayAdapter
3) see code how to inflate that xml in listView
*/