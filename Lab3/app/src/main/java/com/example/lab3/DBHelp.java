package com.example.lab3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelp extends SQLiteOpenHelper {
    public DBHelp(@Nullable Context context) {
        super(context, "Students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Students (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FullName TEXT," +
                "AddingDate TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
