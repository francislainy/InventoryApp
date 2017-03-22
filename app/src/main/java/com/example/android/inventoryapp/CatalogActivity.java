package com.example.android.inventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CatalogActivity extends AppCompatActivity {

    private ProductDBHelper productDBHelper;
    private TextView productName;
    private TextView productPrice;
    private TextView productQuantity;
    private TextView productSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        productDBHelper = new ProductDBHelper(this);
        SQLiteDatabase db = productDBHelper.getWritableDatabase();
        Cursor todoCursor = db.rawQuery("SELECT * FROM " + productDBHelper.TABLE_NAME, null);

        productName = (TextView) findViewById(R.id.productNameView);
        productPrice = (TextView) findViewById(R.id.priceView);
        productQuantity = (TextView) findViewById(R.id.quantityView);
        productSupplier = (TextView) findViewById(R.id.product_price);

//        ArrayList<Product> productsList = new ArrayList<>();
//        productsList.add(new Product("car", "10.0", "5", "Amazon"));
//        productsList.add(new Product("car", "10.0", "5", "Amazon"));
//        productsList.add(new Product("car", "10.0", "5", "Amazon"));
//        productsList.add(new Product("car", "10.0", "5", "Amazon"));

        ProductAdapter adapter = new ProductAdapter(this, todoCursor);





        ListView listView = (ListView) findViewById(R.id.activity_main);



        listView.setAdapter(adapter);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

    }

}
