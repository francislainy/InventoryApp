package com.example.android.inventoryapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {

    private ProductDBHelper productDBHelper;

    private EditText productName;
    private EditText price;
    private EditText quantity;
    private EditText supplier;

    private Button saveDataButton;
    private Button viewAllDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productName = (EditText) findViewById(R.id.add_product_name);
        price = (EditText) findViewById(R.id.add_product_price);
        quantity = (EditText) findViewById(R.id.add_product_quantity);
        supplier = (EditText) findViewById(R.id.add_product_supplier);
        saveDataButton = (Button) findViewById(R.id.save_product_button);
        viewAllDataButton = (Button) findViewById(R.id.add_image_button);

        productDBHelper = new ProductDBHelper(this);

        addData();
        viewData();
    }

    public void addData() {
        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted =  productDBHelper.insertData(new Product(
                        productName.getText().toString(),
                        price.getText().toString(),
                        quantity.getText().toString(),
                        supplier.getText().toString())
                );

                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Error. Data not inserted", Toast.LENGTH_SHORT).show();
                }

                productName.setText("");
                price.setText("");
                quantity.setText("");
                supplier.setText("");

            }
        });
    }

    public void viewData() {
        viewAllDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = productDBHelper.getAllData();

                if (cursor.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuilder builder = new StringBuilder();

                while (cursor.moveToNext()) {
                    builder.append("Id: " + cursor.getString(0) + "\n");
                    builder.append("Name: " + cursor.getString(1) + "\n");
                }

                // show all data
                showMessage("Data", builder.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}