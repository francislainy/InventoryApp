package com.example.android.inventoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product("car", "10.0", "5", "Amazon"));
        productsList.add(new Product("car", "10.0", "5", "Amazon"));
        productsList.add(new Product("car", "10.0", "5", "Amazon"));
        productsList.add(new Product("car", "10.0", "5", "Amazon"));
        productsList.add(new Product("car", "10.0", "5", "Amazon"));

        ProductAdapter adapter = new ProductAdapter(this, productsList);
        ListView listView = (ListView) findViewById(R.id.activity_main);
        listView.setAdapter(adapter);

    }


}
