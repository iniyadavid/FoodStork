package com.example.ctadmin.fabric.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DonorDetailsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "donordetails.db";

    public DonorDetailsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_DONORDB =
                "CREATE TABLE " + DonorDetailsContract.DonorDetailsEntry.TABLE_NAME + " (" +
                        DonorDetailsContract.DonorDetailsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_NAME + " TEXT NOT NULL" + ", " +
                        DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_ADDRESS + " TEXT NOT NULL " + "," +
                        DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_CONTACT + " NUMBER NOT NULL " + "," +
                        DonorDetailsContract.DonorDetailsEntry.COLUMN_DONOR_EMAIL + " TEXT NOT NULL " + " )";
        db.execSQL(SQL_CREATE_DONORDB);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DonorDetailsContract.DonorDetailsEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);

    }
}
