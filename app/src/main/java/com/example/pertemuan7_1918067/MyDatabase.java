package com.example.pertemuan7_1918067;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_geme";
    private static final String tb_clashofclans = "tb_clashofclans";
    private static final String tb_clashofclans_id = "id";
    private static final String tb_clashofclans_username = "username";
    private static final String tb_clashofclans_balaikota = "balaikota";
    private static final String CREATE_TABLE_COC = "CREATE TABLE " +
            tb_clashofclans +"("
            + tb_clashofclans_id + " INTEGER PRIMARY KEY ,"
            + tb_clashofclans_username + " TEXT ,"
            + tb_clashofclans_balaikota + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COC);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMahasiswa(Clashofclans data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_clashofclans_id, data.get_id());
        values.put(tb_clashofclans_username, data.get_username());
        values.put(tb_clashofclans_balaikota, data.get_balaikota());
        db.insert(tb_clashofclans, null, values);
        db.close();
    }
    public List<Clashofclans> ReadMahasiswa() {
        List<Clashofclans> listMhs = new ArrayList<Clashofclans>();
        String selectQuery = "SELECT * FROM " + tb_clashofclans;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Clashofclans data = new Clashofclans();
                data.set_id(cursor.getString(0));
                data.set_username(cursor.getString(1));
                data.set_balaikota(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateMahasiswa (Clashofclans data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_clashofclans_username, data.get_username());
        values.put(tb_clashofclans_balaikota, data.get_balaikota());
        return db.update(tb_clashofclans, values, tb_clashofclans_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMahasiswa(Clashofclans data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_clashofclans,tb_clashofclans_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

