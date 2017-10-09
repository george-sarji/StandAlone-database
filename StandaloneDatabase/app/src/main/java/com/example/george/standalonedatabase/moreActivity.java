package com.example.george.standalonedatabase;

import android.app.Activity;
import android.os.Bundle;

public class moreActivity extends Activity {

    Task mTask;
    DatabaseManager mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        mDb = new DatabaseManager(this);
        String task_id = getIntent().getStringExtra("task_id");
        mTask = mDb.getTaskById(task_id);

    }
}
