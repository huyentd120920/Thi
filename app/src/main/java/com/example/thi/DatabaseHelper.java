package com.example.thi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "dbRau", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableRau = "create table Rau(marau text primary key, tenrau text, gia text)";
    db.execSQL(createTableRau);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists Rau");
onCreate(db);
    }
}
