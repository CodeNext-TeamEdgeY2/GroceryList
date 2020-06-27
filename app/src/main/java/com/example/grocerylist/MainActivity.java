package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText itemName;

    EditText listName;

    String actualItem;
    String actualListName = "";

    SharedPreferences sharedPrefs;
    FirebaseDatabase fdb;
    DatabaseReference dr;

    DatabaseReference dr2;

    String sharedPrefString = "";

    CategoryItemAdapter arrayAdapter;

    //ArrayList<String> arrayListOfGroceryItems = new ArrayList<String>();
    ArrayList<String> dropdown = new ArrayList<String>();

    ArrayList<String> dropdownListNames = new ArrayList<String>();

    ArrayList<String> pullToPopulate = new ArrayList<String>();

    Spinner spinner;

    ListView groceryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_creation);


        itemName = findViewById(R.id.item_name);
        listName = findViewById(R.id.list_name);
        dropdown.add("Select a list");
        dropdownListNames.add("Select a list");

        sharedPrefs
                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);

        fdb = FirebaseDatabase.getInstance();

        if (sharedPrefString != "") {
            sharedPrefString = sharedPrefs.getString("grocery list", "Empty List");
        }

        sharedPrefString = sharedPrefs.getString("grocery list", "Empty List");

        groceryListView = findViewById(R.id.groceryLV);

        String[] stringArrayList = sharedPrefString.split(",");


        Toast.makeText(getApplicationContext(),"To put multiple items spearate by putting a comma", Toast.LENGTH_SHORT).show();

        dr = fdb.getReference().child("list names");

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dropdownListNames.removeAll(dropdownListNames);
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    String string = snap.getValue().toString();
                    //Log.d("Testing", string);

                    if (string.startsWith("{") == false) {
                        dropdownListNames.add(string);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        //String[] tmpDropdown = {"recommended by the creators", "troll items"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dropdownListNames);
        // Apply the adapter to the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int var = 0;

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                Toast.makeText(getApplicationContext(), (CharSequence) spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(getApplicationContext(), "Nothing selected", Toast.LENGTH_SHORT).show();

            }
        });

        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        arrayAdapter = new CategoryItemAdapter
                (this, pullToPopulate);

        groceryListView.setAdapter(arrayAdapter);
    }

    public void createList(View view) {
        actualListName = listName.getText().toString();

        dropdown.add(actualListName);

        dr.push().setValue(actualListName);

//        sharedPrefs
//                = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);

        sharedPrefString = sharedPrefs.getString(actualListName, "");
    }

    public void addToList(View view) {
        //Log.d("Something", spinner.getSelectedItem().toString());

        actualItem = itemName.getText().toString();

        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString("grocery list", sharedPrefString + actualItem + ", ");

        editor.apply();

        sharedPrefString = sharedPrefs.getString("grocery list", null);

        String selectedString = spinner.getSelectedItem().toString();

        dr2 = fdb.getReference().child("list names").child(selectedString);

        dr2.push().setValue(actualItem);

        dr.child(selectedString).addValueEventListener(new ValueEventListener() {
            int var = 0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pullToPopulate.removeAll(pullToPopulate);
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    String string = snap.getValue().toString();
                    var += 1;
                    if (string.startsWith("{") == false) {
                        pullToPopulate.add(string);
                        Log.d("Testing", var + string);
                    }
                }
                Log.d("Dunno anymore bro", pullToPopulate.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        arrayAdapter.notifyDataSetChanged();

        //finish();
        //startActivity(getIntent());
    }
}