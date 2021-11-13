package com.example.listviewcusomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter {

    private String[] arr;
    private Context context;

    public MyAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.arr = arr;
        this.context = context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //first create your own layout (file)

        //Inflate your custom layout to find id of views in it
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_custom_layout, parent,false);

        TextView tv = convertView.findViewById(R.id.textView);
        tv.setText(getItem(position));

        //set on click listener before rendering view
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked item " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
