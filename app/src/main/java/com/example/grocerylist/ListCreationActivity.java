package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCreationActivity extends AppCompatActivity {

    EditText itemName;
    String actualItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_creation);


        itemName = findViewById(R.id.item_name);
        actualItem = itemName.getText().toString();

        ListView groceryListView = findViewById(R.id.groceryLV);

        ArrayList<String> stringArrayList = new ArrayList<String>();

        CategoryItemAdapter arrayAdapter = new CategoryItemAdapter
                (this, stringArrayList);

        groceryListView.setAdapter(arrayAdapter);
    }

    public void addToList(View view) {
        SharedPreferences sharedPrefs
                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString("grocery list", actualItem);

        editor.apply();

        //CategoryItemAdapter iA = new CategoryItemAdapter(this, actualItem);
    }
}
