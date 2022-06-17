package com.caolambaokhanh.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME="sach_database.sqlite";
    public static final String TBL_NAME="Sach";
    public static final int DB_VERSION=1;
    public static final String COL_ID="SachId";
    public static final String COL_NAME="SachName";
    public static final String COL_PRICE="SachPrice";

    public CreateDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS "+ TBL_NAME +" ("+ COL_ID + " INTEGER PRIMARY KEY, " + COL_NAME + " VARCHAR(200), " + COL_PRICE + " REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(db);
    }
    public void execQuery(String sql){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        return  db.rawQuery(sql,null);
    }
    public int getNumbofProduct(){
        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ TBL_NAME,null);
        int count= cursor.getCount();
        cursor.close();
        return count;
    }
    public void crateSomeDefaultProduct() {
        int count = this.getNumbofProduct();
        if (count == 0) {
            execQuery("INSERT INTO " + TBL_NAME + " VALUES(1,'Hoa vang',19000)");
            execQuery("INSERT INTO " + TBL_NAME + " VALUES(2,'Nguyeen nhaat anh',17000)");
            execQuery("INSERT INTO " + TBL_NAME + " VALUES(3,'Lam giau',20000)");
        }
    }
}
