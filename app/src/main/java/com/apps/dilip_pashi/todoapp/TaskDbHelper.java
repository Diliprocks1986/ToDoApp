package com.apps.dilip_pashi.todoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dilip_pashi on 25-11-2016.
 */

public class TaskDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "todolist.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";
    public static final String _ID = "_id";
    public static final String COL_TASK_TITLE = "title";

    public TaskDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TASK_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}