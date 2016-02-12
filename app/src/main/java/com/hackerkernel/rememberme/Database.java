package com.hackerkernel.rememberme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "remember.db";
    private static final int VERSION = 1;

    private static final String TAG = Database.class.getSimpleName();

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        Log.d(TAG, "HUS: constructor run");
    }

    public long savakeys(String email, String password, String category, String username) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("email",email);
        cv.put("password",password);
        cv.put("category", category);
        cv.put("username", username);

        return db.insert("re",null,cv);
    }

    public List<CredintialsPojo> getkeys(String category, String username) {

        SQLiteDatabase db = this.getWritableDatabase();
        List<CredintialsPojo> list = new ArrayList<>();
        String[] col = {"email","password"};
        String where = "category = ? AND username = ?";
        String[] whereArgs = {category,username};
        Cursor cursor = db.query("re", col, where, whereArgs, null, null, null);
        while (cursor.moveToNext()){
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            CredintialsPojo pojo = new CredintialsPojo();
            pojo.setEmail(email);
            pojo.setPassword(password);
            //to list
            list.add(pojo);
        }
        cursor.close();
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE re (_id INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT,username TEXT,category TEXT);";
        db.execSQL(table);
        Log.d(TAG, "HUS: ON create run");
    }
    //DELETED DataBASE
    public int deletedata(){
        SQLiteDatabase sqLiteDatabase  = this.getWritableDatabase();
        String[] where = {"murtaza"};
        int lon= sqLiteDatabase.delete("re", "email"+"=?", where);
        Log.d(TAG, "MUR:: DELETE run");
        return lon;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete = "DROP TABLE IF EXISTS re";
        db.execSQL(delete);

        onCreate(db);
        Log.d(TAG, "HUS: upgrade");


    }
}
