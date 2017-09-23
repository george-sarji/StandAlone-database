package com.example.george.standalonedatabase;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseManager mDBMgr = new DatabaseManager(this);
        SQLiteDatabase mDB = mDBMgr.getWritableDatabase();

    }
}
