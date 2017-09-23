package com.example.george.standalonedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by George on 9/23/2017.
 */

public class DatabaseManager{

    public static final String DB_NAME="MemoDatabase.accdb";
    public static final int DB_VER=1;
    // Here we list the names of the fields that we have in the tables in the database
    public static final String ID="ID";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String DATE="DATE";
    public static final String TIME="TIME";
    public static final String PRIORITY="PRIORITY";
    public static final String PHOTO="PHOTO";
    public static final String TITLE="TITLE";
    public static final String DONE="0";
    // Here we list the names of the tables that we will be working with, identical to the way we listed the fields in the tables
    public static final String TASKS_TABLE="TASKS";
    // Here we initiate a script to start a new table in the database
    public static final String CREATE_TASKS_TABLE = "create table "+TASKS_TABLE + " ("+ID+" integer primary key autoincrement, "+
            TITLE+" text, " +
            DESCRIPTION + " text not null, "+
            DATE + " text not null, "+
            TIME+ " text not null, " +
            PRIORITY + " text not null, " +
            PHOTO + " blob, "+
            DONE+" text)";

    private class DatabaseTool extends SQLiteOpenHelper {

        public DatabaseTool(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("drop table if exists "+DB_NAME);
            sqLiteDatabase.execSQL(CREATE_TASKS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

    private DatabaseTool mDbTool;
    public DatabaseManager(Context context)
    {
        mDbTool = new DatabaseTool(context, DB_NAME, null, DB_VER);
    }

    public void AddTask(String title, String description, String date, String time, String priority, byte[] photo, String done)
    {
        String sqlExecs = "insert into [Tasks] ([title], [description], [date], [time], [priority], [photo], [done]) values({0}, {1}, {2}, {3}, {4}, {5}, {6})";
        // Method 1 - Use strings to execute sql lines:
        sqlExecs=String.format(sqlExecs, title, description, date, time, priority, photo, done);
        SQLiteDatabase mDbWrite = mDbTool.getWritableDatabase();
        mDbWrite.execSQL(sqlExecs);
        // Method 2 - Use ContentValues to implement the fields
        ContentValues mCv = new ContentValues();
        mCv.put(TITLE, title);
        mCv.put(DESCRIPTION, description);
        mCv.put(DATE, date);
        mCv.put(TIME, time);
        mCv.put(PRIORITY, priority);
        mCv.put(PHOTO, photo);
        mCv.put(DONE, done);
        mDbWrite.insert(TASKS_TABLE, null, mCv);

    }


}
