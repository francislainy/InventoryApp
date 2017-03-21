package com.example.android.inventoryapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDescriptionActivity extends AppCompatActivity {

    private TextView productNameView;
    private TextView productPriceView;
    private TextView productQuantityView;
    private TextView productSupplierView;

    private int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        productNameView = (TextView) findViewById(R.id.product_name);
        productPriceView = (TextView) findViewById(R.id.product_price);
        productQuantityView = (TextView) findViewById(R.id.product_quantity);
        productSupplierView = (TextView) findViewById(R.id.product_supplier);

        /**
         * Add sale to TextView when addSaleButton is clicked (Increase value of quantity variable)
         */
        Button addSaleButton = (Button) findViewById(R.id.addSaleButton);
        addSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                productQuantityView.setText(String.valueOf(quantity));
            }
        });

        /**
         * Add shipment to TextView when addShipmentButton is clicked (Decrease value of quantity variable)
         */
        Button addShipmentButton = (Button) findViewById(R.id.addShipmentButton);
        addShipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;

                if (quantity < 0) {
                    quantity = 0;
                    Toast.makeText(getApplicationContext(), "Can't go lower than zero", Toast.LENGTH_SHORT).show();
                }

                productQuantityView.setText(String.valueOf(quantity));
            }
        });

    }

    /**
     * Set menu on top of page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.isChecked()) {
            item.setChecked(false);
        }
        else {
            item.setChecked(true);
        }
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F44336")));
        return super.onOptionsItemSelected(item);
    }

}