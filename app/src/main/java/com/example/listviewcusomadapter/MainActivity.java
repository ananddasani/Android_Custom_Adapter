package com.example.listviewcusomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] arr = {"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.listView);

        MyAdapter ma = new MyAdapter(MainActivity.this, R.layout.my_custom_layout, arr);
        listView.setAdapter(ma);

        //set item click listener in custom adapter file before rendering(returning) view
    }
}
