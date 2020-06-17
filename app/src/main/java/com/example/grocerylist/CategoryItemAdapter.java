package com.example.grocerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryItemAdapter extends ArrayAdapter<String> {
    public CategoryItemAdapter(Context context, String[] list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.existing_list_item, parent, false);
        String currentStringItem = getItem(position);
        TextView categoryItemTextView = convertView.findViewById(R.id.item_in_grocery_list);
        categoryItemTextView.setText(currentStringItem);

        return convertView;
    }
}
