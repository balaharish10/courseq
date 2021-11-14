package com.example.courseq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class userdatabase extends SQLiteOpenHelper {
    public userdatabase(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("email", email);
        content.put("password", pass);
        double res = db.insert("user", null, content);
        if (res == -1)
            return false;
        else
            return true;
    }

    public boolean check(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user where email=?", new String[]{email});
        if (c.getCount() > 0)
            return false;
        else
            return true;
    }

    public boolean logincheck(String email, String password) {
SQLiteDatabase db=this.getReadableDatabase();
Cursor d=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
if(d.getCount()>0)
    return true;
else
    return false;
    }
}
