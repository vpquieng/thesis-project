package com.example.test;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "QueensDatabase.db";
    private DatabaseContract(){}
    public static class UsersTable implements BaseColumns{
        public static String TABLE_NAME = "users";
        public static String USER_UNAME_COL = "user_uname";
        public static String USER_LNAME_COL = "user_lname";
        public static String USER_FNAME_COL = "user_fname";
        public static String USER_MNAME_COL = "user_mname";
        public static String USER_ADDRESS_COL = "user_address";
        public static String USER_PASS_COL = "user_pass";
        public static String USER_BRANCH_COL = "user_branch";
        public static String USER_DESIGNATION_COL = "user_designation";
        public static String USER_ROLE_COL = "user_role";
        public static String USER_PIC_COL = "user_pic";
        public static String USER_CREATION_COL = "user_creationDate";
        public static String USER_CREATOR_COL = "user_creator";
        public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static String TRUNCATE_TABLE = "DELETE FROM " + TABLE_NAME;
        public static String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY," +
                        USER_UNAME_COL + " TEXT," +
                        USER_LNAME_COL + " TEXT," +
                        USER_FNAME_COL + " TEXT," +
                        USER_MNAME_COL + " TEXT," +
                        USER_ADDRESS_COL + " TEXT," +
                        USER_PASS_COL + " TEXT," +
                        USER_BRANCH_COL + " TEXT," +
                        USER_ROLE_COL + " TEXT," +
                        USER_DESIGNATION_COL + " TEXT," +
                        USER_PIC_COL + " BLOB," +
                        USER_CREATION_COL + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        USER_CREATOR_COL + " INTEGER REFERENCES users(_ID))";
    }

    public static class MedicinesTable implements BaseColumns{
        public static String TABLE_NAME = "medicines";
        public static String MED_NAME = "med_name";
        public static String MED_CATEGORY = "med_category";
        public static String MED_DESCRIPTION = "med_description";
        public static String MED_SHELFLIFE = "med_shelflife";
        public static String MED_PIC = "med_pic";
        public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static String TRUNCATE_TABLE = "DELETE FROM " + TABLE_NAME;
        public static String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY," +
                        MED_NAME + " TEXT," +
                        MED_CATEGORY + " TEXT," +
                        MED_DESCRIPTION + " TEXT," +
                        MED_SHELFLIFE + " INTEGER," +
                        MED_PIC + " BLOB)";
    }

    public static class InventoryTable implements BaseColumns{
        public static String TABLE_NAME = "inventory";
        public static String MED_ID = "med_id";
        public static String INV_RECEPTION = "inv_reception";
        public static String INV_EXPIRY = "inv_expiry";
        public static String INV_DESCRIPTION = "inv_description";
        public static String INV_QUANTITY = "inv_quantity";
        public static String INV_QRCODE = "inv_qrcode";
        public static String INV_CONSUMPTIONRATE = "inv_consumptionRate";
        public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static String TRUNCATE_TABLE = "DELETE FROM " + TABLE_NAME;
        public static String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY," +
                        MED_ID + " INTEGER REFERENCES medicines(_ID)," +
                        INV_RECEPTION + " DATE," +
                        INV_EXPIRY + " DATE," +
                        INV_DESCRIPTION + " TEXT," +
                        INV_QUANTITY + " INTEGER," +
                        INV_QRCODE + " TEXT," +
                        INV_CONSUMPTIONRATE + " FLOAT)";
    }

    public static class DeliveriesTable implements BaseColumns{
        public static String TABLE_NAME = "deliveries";
        public static String DLV_RECEPTION = "dlv_reception";
        public static String DLV_RECEPTOR = "dlv_receptor";
        public static String DLV_COURIER = "dlv_courier";
        public static String DLV_SOURCE = "dlv_source";
        public static String DLV_DESTINATION = "dlv_destination";
        public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static String TRUNCATE_TABLE = "DELETE FROM " + TABLE_NAME;
        public static String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY," +
                        DLV_RECEPTOR + " INTEGER REFERENCES users(_ID)," +
                        DLV_RECEPTION + " DATE," +
                        DLV_COURIER + " DATE," +
                        DLV_SOURCE + " INTEGER," +
                        DLV_DESTINATION + " TEXT)";
    }

    public static class TransactionsTable implements BaseColumns{
        public static String TABLE_NAME = "transactions";
        public static String TRNS_TRANSACTOR = "trns_transactor";
        public static String TRNS_DATE = "trns_date";
        public static String TRNS_INVENTORY = "trns_inventory";
        public static String TRNS_QTYISSUED = "trns_qtyissued";
        public static String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static String TRUNCATE_TABLE = "DELETE FROM " + TABLE_NAME;
        public static String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        _ID + " INTEGER PRIMARY KEY," +
                        TRNS_TRANSACTOR + " INTEGER REFERENCES users(_ID)," +
                        TRNS_DATE + " DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        TRNS_INVENTORY + " INTEGER REFERENCES inventory(_ID)," +
                        TRNS_QTYISSUED + " INTEGER)";
    }
}
