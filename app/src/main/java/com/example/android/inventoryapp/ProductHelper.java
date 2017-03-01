package com.example.android.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Francislainy on 27/02/2017.
 */

public class ProductHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";

    private static final String TABLE_NAME = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCT = "product_name";
    private static final String COLUMN_PRICE = "10";
    private static final String COLUMN_QUANTITY = "0";
    private static final String COLUMN_SUPPLIER = "AMAZON";

    public ProductHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", " +
                COLUMN_PRODUCT + " TEXT" + ", " +
                COLUMN_PRICE + " TEX" + ", " +
                COLUMN_QUANTITY + " TEXT" + ", " +
                COLUMN_SUPPLIER + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT, product.getProductName());
        values.put(COLUMN_PRICE, product.getPrice());
        values.put(COLUMN_QUANTITY, product.getQuantity());
        values.put(COLUMN_SUPPLIER, product.getSupplier());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        while (!cursor.isAfterLast()) {
            dbString += cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT));
        }

        return  dbString;
    }
}