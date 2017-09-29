package com.example.george.standalonedatabase;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addTask(View v)
    {
        // Switch to AddTask intent
        Intent addTaskActivity = new Intent(this, AddTask.class);
        startActivity(addTaskActivity);
        finish();

    }
    public void showTasks(View v)
    {
        DatabaseManager mDBMgr = new DatabaseManager(this);
        TextView mTasks = (TextView)findViewById(R.id.taskText);
        mTasks.setText(mDBMgr.GetAllTaskDetails());
        // PLAN for new showTasks: Add button for each task inside the scrollable layout
        Task[] myTasks = mDBMgr.GetAllTasksDetailsArray();
        TableLayout mTable = (TableLayout)findViewById(R.id.tableLayout);
//        TableRow firstRow = new TableRow(this);
//        TextView mTitleField = new TextView(this);
//        mTitleField.setText("Title");
//        firstRow.addView(mTitleField);
//        TextView mDescField = new TextView(this);
//        mDescField.setText("Description");
//        firstRow.addView(mDescField);
//        TextView mDateField = new TextView(this);
//        mDateField.setText("Date");
//        firstRow.addView(mDateField);
//        TextView mTimeField = new TextView(this);
//        mTimeField.setText("Time");
//        firstRow.addView(mTimeField);
//        TextView mDone = new TextView(this);
//        mDone.setText("Done");
//        firstRow.addView(mDone);
//        TextView mEdit = new TextView(this);
//        mEdit.setText("Edit");
//        firstRow.addView(mEdit);
//        mTable.addView(firstRow);
        for(int i=0;i<myTasks.length;i++)
        {
            TableRow mRow = new TableRow(this);
            // TODO: Add a new view for each field in the table
            TextView mTitleField = new TextView(this);
            mTitleField.setText(myTasks[i].getTitle());
            mRow.addView(mTitleField);
            TextView mDescField = new TextView(this);
            mDescField.setText(myTasks[i].getDescription());
            mRow.addView(mDescField);
            TextView mDateField = new TextView(this);
            mDateField.setText(myTasks[i].getDate());
            mRow.addView(mDateField);
            TextView mTimeField = new TextView(this);
            mTimeField.setText(myTasks[i].getTime());
            mRow.addView(mTimeField);
            TextView mDone = new TextView(this);
            mDone.setText(myTasks[i].getDone());
            mRow.addView(mDone);
            Button mEditButton = new Button(this);
            mEditButton.setText("Edit");
            mEditButton.setTag(myTasks[i]);
            mRow.addView(mEditButton);
            mTable.addView(mRow);
            // TODO: Add a view inside table which is the TableRow
            // TODO: Change tags for the button
        }
    }
}
