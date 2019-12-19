package com.example.thi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class RauDAO {

    private SQLiteDatabase sqLiteDB;
    private DatabaseHelper dbHelper;
    private Context context;

    public RauDAO(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        sqLiteDB = dbHelper.getWritableDatabase();
    }

    public boolean insertRau(Rau objrau) {
        try {
            ContentValues values = new ContentValues();
            values.put("marau", objrau.getMarau());
            values.put("tenrau", objrau.getTenrau());
            values.put("gia", objrau.getGia());
            long numInsert = sqLiteDB.insert("Rau", null, values);
            if (numInsert <= 0)
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Rau> getAllRau() {
        List<Rau> danhSachRau = new ArrayList<>();
        String sqlSelect = "select marau, tenrau, gia from LoaiChi";
        Cursor cursor = sqLiteDB.rawQuery(sqlSelect, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String marau = cursor.getString(0);
            String tenrau = cursor.getString(1);
            String gia = cursor.getString(2);

            Rau objRau = new Rau(marau,tenrau,gia);
            danhSachRau.add(objRau);
            cursor.moveToNext();
        }
        return danhSachRau;
    }
}

