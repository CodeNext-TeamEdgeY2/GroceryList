package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListCreationActivity extends AppCompatActivity {
//
//    EditText itemName;
//
//    EditText listName;
//
//    String actualItem;
//    String actualListName = "";
//
//    SharedPreferences sharedPrefs;
//    FirebaseDatabase fdb;
//    DatabaseReference dr;
//
//    String sharedPrefString = "";
//    String sharedPrefLists = "";
//
//    CategoryItemAdapter arrayAdapter;
//
//    Spinner spinner;
//
//    //ArrayList<String> arrayListOfGroceryItems = new ArrayList<String>();
//    ArrayList<String> dropdown = new ArrayList<String>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_creation);
//
//
//        itemName = findViewById(R.id.item_name);
//        listName = findViewById(R.id.list_name);
//
//
//        sharedPrefs
//                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);
//
//        //fdb = FirebaseDatabase.getInstance();
//        //dr = fdb.getReference().child("grocery list");
//
//
//        if (sharedPrefString != "") {
//            sharedPrefString = sharedPrefs.getString("grocery list", "Empty List");
//        }
//
//        sharedPrefString = sharedPrefs.getString("grocery list", "Empty List");
//
//        ListView groceryListView = findViewById(R.id.groceryLV);
//
//        String[] stringArrayList = sharedPrefString.split(",");
//
//        arrayAdapter = new CategoryItemAdapter
//                (this, stringArrayList);
//
//        groceryListView.setAdapter(arrayAdapter);
//        Toast.makeText(getApplicationContext(),"To put multiple items spearate by putting a comma", Toast.LENGTH_SHORT).show();
//
//
//
//        spinner = (Spinner) findViewById(R.id.spinner);
//        //String[] tmpDropdown = {"recommended by the creators", "troll items"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dropdown);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//
//    }
//
//    public void createList(View view) {
//        actualListName = listName.getText().toString();
//
//        dropdown.add(actualListName);
//
////        sharedPrefs
////                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);
//
//        sharedPrefString = sharedPrefs.getString(actualListName, "Empty List");
//
//        SharedPreferences.Editor editor = sharedPrefs.edit();
//
//        editor.putString("list names", sharedPrefLists + actualListName + ", ");
//    }
//
//    public void addToList(View view) {
//
//        actualItem = itemName.getText().toString();
//
//        SharedPreferences.Editor editor = sharedPrefs.edit();
//
//        String spinnerText = spinner.getSelectedItem().toString();
//
//        editor.putString(spinnerText, sharedPrefString + actualItem + ", ");
//
//        editor.apply();
//
//        sharedPrefString = sharedPrefs.getString(spinnerText, "Empty List");
//
//        arrayAdapter.notifyDataSetChanged();
//
//        //finish();
//        //startActivity(getIntent());
//    }
}
