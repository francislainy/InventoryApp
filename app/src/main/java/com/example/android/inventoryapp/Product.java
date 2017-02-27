package com.example.android.inventoryapp;

/**
 * Created by Francislainy on 27/02/2017.
 */
public class Product {
    private String productName;
    private String price;
    private String quantity;
    private String supplier;

    public Product(String productName, String price, String quantity, String supplier) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

}
