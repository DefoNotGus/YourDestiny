package com.example.yourdestiny;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "YourDestinyDB";
    private static final int DATABASE_VERSION = 1;

    // Define your table and column names
    public static final String TABLE_NAME = "HoroscopesSaved";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    // ... add more columns as needed

    // SQL statement to create the table
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT);";

    // Constructor for the DatabaseHelper class
    public DatabaseHelper(Context context) {
        // Call the superclass constructor to initialize the database
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is first created
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table by executing the SQL CREATE TABLE statement
        db.execSQL(CREATE_TABLE);
    }

    // Called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade the database if needed
        // This method is called when the database version changes
        // You can add ALTER TABLE statements here to modify the existing schema
        // For example, you can add statements to add new columns or modify existing ones
    }
}
