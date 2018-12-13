package com.accounting.one.accountingapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;


/**
 * Created by one on 2018/12/13.
 * 描述：TODO
 */

public class RecordDatabaseHelper extends SQLiteOpenHelper {

    private static String TAG = "RecordDatabaseHelper";

    public static final String DB_NAME = "record";

    private static final String CREATE_RECORD_DB = "create table record("
            + "id integer primary key autoincrement,"
            +"uuid text,"
            +"amount double,"
            +"remark text,"
            +"type integer,"
            +"category text,"
            +"time integer,"
            +"date date)";

    public RecordDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECORD_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecord(RecordBean recordBean){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid",recordBean.getUuid());
        values.put("type",recordBean.getType());
        values.put("category",recordBean.getCategory());
        values.put("date",recordBean.getDate());
        values.put("amount",recordBean.getAmount());
        values.put("remark",recordBean.getRemark());
        values.put("time",recordBean.getTimeStamp());
        db.insert(DB_NAME,null,values);
    }

    public void removeRecord(String uuid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME,"uuid=?",new String[]{uuid});
    }

    public void editRecord(String uuid,RecordBean record){
        removeRecord(uuid);
        record.setUuid(uuid);
        addRecord(record);
    }

    public LinkedList<RecordBean> readRecords(String dateStr){
        LinkedList<RecordBean> records = new LinkedList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select distince * from record where date = ? order by time asc",new String[]{dateStr});
        if (cursor.moveToFirst()){
            do {
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp = cursor.getLong(cursor.getColumnIndex("time"));

                RecordBean record = new RecordBean();
                record.setUuid(uuid);
                record.setAmount(amount);
                record.setCategory(category);
                record.setDate(date);
                record.setRemark(remark);
                record.setTimeStamp(timeStamp);
                record.setType(type);

                records.add(record);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return records;
    }

    public LinkedList<String> getAvaliableDate(){
        LinkedList<String> dates = new LinkedList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select distinct * from record order by date asc",new String[]{});

        if (cursor.moveToFirst()){
            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));

                if (!dates.contains(date)){
                    dates.add(date);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return dates;
    }
}
