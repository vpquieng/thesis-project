package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DatabaseContract.UsersTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.MedicinesTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.InventoryTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.DeliveriesTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.TransactionsTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.UsersTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.MedicinesTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.InventoryTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.DeliveriesTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.TransactionsTable.DELETE_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}