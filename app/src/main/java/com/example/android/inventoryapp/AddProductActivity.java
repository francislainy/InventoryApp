package com.example.android.inventoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {

    private EditText productName;
    private EditText price;
    private EditText quantity;
    private EditText supplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productName = (EditText) findViewById(R.id.add_product_name);
        price = (EditText) findViewById(R.id.add_product_price);
        quantity = (EditText) findViewById(R.id.add_product_quantity);
        supplier = (EditText) findViewById(R.id.add_product_supplier);

    }
}
