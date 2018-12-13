package com.accounting.one.accountingapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by one on 2018/12/13.
 * 描述：TODO
 */

public class RecordDatabaseHelper extends SQLiteOpenHelper {

    private static String TAG = "RecordDatabaseHelper";

    public static final String DB_NAME = "record";

    private static final String create_record_db = "create";

    public RecordDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
