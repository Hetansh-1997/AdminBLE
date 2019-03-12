package com.example.hetanshshah.adminble.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.hetanshshah.adminble.database.Constants.*;

public class MyDbHelper extends SQLiteOpenHelper {
    public static String DATABASE_PRODUCT = "product";
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "(" + BEACON_ID + " TEXT, " + PRODUCT_NAME + " TEXT, " + PRODUCT_DETAILS + " TEXT )";

    public MyDbHelper(Context context){
        super(context, DATABASE_PRODUCT, null, DATABASE_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATABASE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_PRODUCT_TABLE);
        }
        onCreate(db);
    }
}

