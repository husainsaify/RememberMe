package com.hackerkernel.rememberme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "remember.db";
    private static final int VERSION = 1;

    private static final String TAG = Database.class.getSimpleName();

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        Log.d(TAG,"HUS: constructor run");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE re (_id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT,username TEXT,category TEXT);";
        db.execSQL(table);
        Log.d(TAG,"HUS: ON create run");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete = "DROP TABLE IF EXISTS re";
        db.execSQL(delete);

        onCreate(db);
        Log.d(TAG, "HUS: upgrade");
    }
}