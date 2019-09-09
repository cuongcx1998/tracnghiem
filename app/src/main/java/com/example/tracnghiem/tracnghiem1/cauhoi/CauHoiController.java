package com.example.tracnghiem.tracnghiem1.cauhoi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;



public class CauHoiController {
    private DBHelper dbHelper;

    public CauHoiController(Context context) {
        dbHelper= new DBHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<CauHoi> getQuestion(int num_exam, String subject){
        ArrayList<CauHoi> lsData= new ArrayList<CauHoi>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM tracnghiem WHERE num_exam = '"+num_exam+"' AND subject='"+subject+"'",null);
        cursor.moveToFirst();
        do {
            CauHoi item;
            item= new CauHoi(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8),cursor.getString(9),"");
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
    //Lấy danh sách câu hỏi theo câu hỏi...
    public Cursor getSearchQuestion(String key) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tracnghiem WHERE question LIKE '%"+key+"%'",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
