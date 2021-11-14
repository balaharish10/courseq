package com.example.courseq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database1 extends SQLiteOpenHelper {

    public database1(Context context) {

        super(context, "d1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table detail(subject text primary key,rating text ,remarks text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists detail");
        onCreate(db);
    }
    public boolean insert(String subject, String rating,String remark) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("subject",subject );
        content.put("rating",rating );
        content.put("remarks",remark );


        double res = db.insert("detail", null, content);
        if (res == -1)
            return false;
        else
            return true;
    }
    public Cursor view()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from detail " ;
        Cursor c=db.rawQuery(query,null);
        return c;
    }
    public Cursor view2(String subject)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from detail where subject=?" ;
        Cursor c=db.rawQuery(query,new String[]{subject});
        return c;
    }
}
