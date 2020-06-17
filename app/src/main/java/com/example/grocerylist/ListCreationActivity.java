package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListCreationActivity extends AppCompatActivity {

    EditText itemName;
    String actualItem;
    SharedPreferences sharedPrefs;
    FirebaseDatabase fdb;
    DatabaseReference dr;

    String sharedPrefString;

    ArrayList<String> arrayListOfGroceryItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_creation);


        itemName = findViewById(R.id.item_name);


        sharedPrefs
                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);

        fdb = FirebaseDatabase.getInstance();
        dr = fdb.getReference().child("grocery list");

        sharedPrefString = sharedPrefs.getString("grocery list", "Empty List");

        ListView groceryListView = findViewById(R.id.groceryLV);

        String[] stringArrayList = sharedPrefString.split(",");

        CategoryItemAdapter arrayAdapter = new CategoryItemAdapter
                (this, stringArrayList);

        groceryListView.setAdapter(arrayAdapter);
        Toast.makeText(getApplicationContext(),"To put multiple items spearate by putting a comma", Toast.LENGTH_SHORT).show();

    }

    public void addToList(View view) {

        actualItem = itemName.getText().toString();

        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString("grocery list", sharedPrefString + actualItem + ", ");

        editor.apply();

        finish();
        startActivity(getIntent());
    }
}
