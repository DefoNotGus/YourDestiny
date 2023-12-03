package com.example.yourdestiny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HoroscopeDatabase {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public HoroscopeDatabase(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        // Open the database for writing
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        // Close the database when done
        dbHelper.close();
    }

    // Implement methods to perform CRUD operations
    // Example: Insert data
    public void insertData(String name) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);

        database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }
    public String getLastRecord() {
        String result = null;
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

        if (cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
        }

        cursor.close();
        return result;
    }

    public void deleteAllRecords() {
        database.delete(DatabaseHelper.TABLE_NAME, null, null);
    }

}

