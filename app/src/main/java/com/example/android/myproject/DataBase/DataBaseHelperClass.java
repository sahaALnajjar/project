package com.example.android.myproject.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Msi1 on 2/25/2019.
 */

public class DataBaseHelperClass extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TheWordsDataBase.db";




    public DataBaseHelperClass(Context context){
    super (context , DATABASE_NAME , null ,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
   // db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }



}
