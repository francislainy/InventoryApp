package com.example.android.inventoryapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Francislainy on 27/02/2017.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.productNameView);
        TextView productPrice = (TextView) convertView.findViewById(R.id.priceView);
        TextView productQuantity = (TextView) convertView.findViewById(R.id.quantityView);
        TextView productSupplier = (TextView) convertView.findViewById(R.id.supplierView);
        ImageView productImage = (ImageView) convertView.findViewById(R.id.imageView);

        productName.setText(product.getProductName());
        productPrice.setText(product.getPrice());
        productQuantity.setText(product.getQuantity());
        productSupplier.setText(product.getSupplier());
        //productImage.setImageResource(R.drawable.ic);

        return convertView;
    }
}
