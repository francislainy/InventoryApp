package com.example.android.inventoryapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Francislainy on 27/02/2017.
 */


public class ProductAdapter extends CursorAdapter {

    ProductDBHelper productDBHelper;

    public ProductAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);

       // productDBHelper = new ProductDBHelper(getContext());
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        TextView productName = (TextView) view.findViewById(R.id.productNameView);
        TextView productPrice = (TextView) view.findViewById(R.id.priceView);
        TextView productQuantity = (TextView) view.findViewById(R.id.quantityView);
        TextView productSupplier = (TextView) view.findViewById(R.id.supplierView);
        ImageView productImage = (ImageView) view.findViewById(R.id.imageView);

        String product_name = cursor.getString(cursor.getColumnIndexOrThrow(productDBHelper.COLUMN_PRODUCT));
        String product_price = cursor.getString(cursor.getColumnIndexOrThrow(productDBHelper.COLUMN_PRICE));
        String product_quantity = cursor.getString(cursor.getColumnIndexOrThrow(productDBHelper.COLUMN_QUANTITY));
        String product_supplier = cursor.getString(cursor.getColumnIndexOrThrow(productDBHelper.COLUMN_SUPPLIER));

        productName.setText(product_name);
        productPrice.setText(product_price);
        productQuantity.setText(product_quantity);
        productSupplier.setText(product_supplier);

//        productQuantity.setText(product.getQuantity());
//        productSupplier.setText(product.getSupplier());

        //productImage.setImageResource(R.drawable.ic);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDescriptionActivity.class);
                context.startActivity(intent);
            }
        });

    }
}
