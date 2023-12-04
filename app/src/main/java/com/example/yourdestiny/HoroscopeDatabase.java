package com.example.yourdestiny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HoroscopeDatabase {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    // Constructor to initialize the HoroscopeDatabase with a DatabaseHelper instance
    public HoroscopeDatabase(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Open the database for writing
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    // Close the database when done
    public void close() {
        dbHelper.close();
    }

    // Insert data into the database
    public void insertData(String name) {
        // Create a ContentValues object to hold the data
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);

        // Insert the data into the specified table
        database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    // Retrieve the last record from the database
    public String getLastRecord() {
        String result = null;

        // Query the database to retrieve the last record
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_NAME,
                new String[] { DatabaseHelper.COLUMN_NAME },
                null,
                null,
                null,
                null,
                DatabaseHelper.COLUMN_ID + " DESC",
                "1"
        );

        // Check if the cursor has data
        if (cursor.moveToFirst()) {
            // Retrieve the value of the specified column from the cursor
            result = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
        }

        // Close the cursor to release its resources
        cursor.close();
        return result;
    }

    // Delete all records from the database
    public void deleteAllRecords() {
        // Delete all records from the specified table
        database.delete(DatabaseHelper.TABLE_NAME, null, null);
    }
}
