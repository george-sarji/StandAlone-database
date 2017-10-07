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
    public static Task clickedTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addTask(View v) {
        // Switch to AddTask intent
        Intent addTaskActivity = new Intent(this, AddTask.class);
        startActivity(addTaskActivity);
        finish();

    }

    public void showTasks(View v) {
        DatabaseManager mDBMgr = new DatabaseManager(this);
        TextView mTasks = (TextView) findViewById(R.id.taskText);
//        mTasks.setText(mDBMgr.GetAllTaskDetails());
        // PLAN for new showTasks: Add button for each task inside the scrollable layout
        int width = (int) (this.getWindowManager().getDefaultDisplay().getWidth() * 0.8) / 6;
//        int height = (int)(this.getWindowManager().getDefaultDisplay().getHeight()*0.8)/6;
        TableLayout.LayoutParams mParams = new TableLayout.LayoutParams(width, 50);
//        mTable.setLayoutParams(mParams);
        Task[] myTasks = mDBMgr.GetAllTasksDetailsArray();
        TableLayout mTable = (TableLayout) findViewById(R.id.tableLayout);
        mTable.removeAllViews();
        TableRow firstRow = new TableRow(this);
        TextView mTitleField = new TextView(this);
        mTitleField.setText("Title");
        mTitleField.setLayoutParams(mParams);
        firstRow.addView(mTitleField);
        TextView mDescField = new TextView(this);
        mDescField.setText("Description");
        mDescField.setLayoutParams(mParams);
        firstRow.addView(mDescField);
        TextView mDateField = new TextView(this);
        mDateField.setText("Date");
        mDateField.setLayoutParams(mParams);
        firstRow.addView(mDateField);
        TextView mTimeField = new TextView(this);
        mTimeField.setText("Time");
        mTimeField.setLayoutParams(mParams);
        firstRow.addView(mTimeField);
        TextView mDone = new TextView(this);
        mDone.setText("Done");
        mDone.setLayoutParams(mParams);
        firstRow.addView(mDone);
        TextView mEdit = new TextView(this);
        mEdit.setText("Edit");
        mEdit.setLayoutParams(mParams);
        firstRow.addView(mEdit);
        mTable.addView(firstRow);
        for (int i = 0; i < myTasks.length; i++) {
            TableRow mRow = new TableRow(this);
            mRow.setLayoutParams(mParams);
            // TODO: Add a new view for each field in the table
            mTitleField = new TextView(this);
            mTitleField.setText(myTasks[i].getTitle());
            mTitleField.setTextSize(25);
            mTitleField.setLayoutParams(mParams);
            mRow.addView(mTitleField);
            mDescField = new TextView(this);
            mDescField.setText(myTasks[i].getDescription());
            mDescField.setTextSize(25);
            mRow.addView(mDescField);
            mDateField = new TextView(this);
            mDateField.setText(myTasks[i].getDate());
            mDateField.setTextSize(25);
            mRow.addView(mDateField);
            mTimeField = new TextView(this);
            mTimeField.setText(myTasks[i].getTime());
            mTimeField.setTextSize(25);
            mRow.addView(mTimeField);
            mDone = new TextView(this);
            mDone.setText(myTasks[i].getDone());
            mDone.setTextSize(25);
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

    public void renderTasks(View v) {
        // Get the table layout
        TableLayout mTable = (TableLayout) findViewById(R.id.tableLayout);
        // Get width for screen
        int width = (int) (this.getWindowManager().getDefaultDisplay().getWidth()) / 6;
        mTable.removeAllViews();
        // Construct first row and set its parameters
        TextView mTitle = new TextView(this);
        TextView mDesc = new TextView(this);
        TextView mDate = new TextView(this);
        TextView mTime = new TextView(this);
        TextView mDone = new TextView(this);
        Button mEditButton = new Button(this);
        TextView mEdit = new TextView(this);
        // Begin filling first row
        mTitle.setWidth(width);
        mTitle.setText("Title");
        mTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        mDesc.setWidth(width);
        mDesc.setText("Description");
        mDesc.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        mDate.setWidth(width);
        mDate.setText("Date");
        mDate.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        mTime.setWidth(width);
        mTime.setText("Time");
        mTime.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        mDone.setWidth(width);
        mDone.setText("Done");
        mDone.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        mEdit.setWidth(width);
        mEdit.setText("Edit");
        mEdit.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        // Construct first row object
        TableRow mFirst = new TableRow(this);
        // Add all the views into the first row
        mFirst.addView(mTitle);
        mFirst.addView(mDesc);
        mFirst.addView(mDate);
        mFirst.addView(mTime);
        mFirst.addView(mDone);
        mFirst.addView(mEdit);
        // Add the row into the table layout
        mTable.addView(mFirst);
        // Get all the tasks
        DatabaseManager mDb = new DatabaseManager(this);
        Task[] myTasks = mDb.GetAllTasksDetailsArray();
        for( int i=0; i<myTasks.length;i++)
        {
            mTitle = new TextView(this);
            mDesc = new TextView(this);
            mDate = new TextView(this);
            mTime = new TextView(this);
            mDone = new TextView(this);
            mEditButton = new Button(this);
            // Begin filling first row
            mTitle.setWidth(width);
            mTitle.setText(myTasks[i].getTitle());
            mTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mDesc.setWidth(width);
            mDesc.setText(myTasks[i].getDescription());
            mDesc.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mDate.setWidth(width);
            mDate.setText(myTasks[i].getDate());
            mDate.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mTime.setWidth(width);
            mTime.setText(myTasks[i].getTime());
            mTime.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mDone.setWidth(width);
            mDone.setText(myTasks[i].getDone());
            mDone.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mEditButton.setWidth(width);
            mEditButton.setText("Edit");
            mEditButton.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mEditButton.setTag(myTasks[i]);
            mEditButton.setOnClickListener(mClickerEdit);
            TableRow mRow = new TableRow(this);
            mRow.addView(mTitle);
            mRow.addView(mDesc);
            mRow.addView(mDate);
            mRow.addView(mTime);
            mRow.addView(mDone);
            mRow.addView(mEditButton);
            mTable.addView(mRow);
        }
    }
    View.OnClickListener mClickerEdit = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent editActivity = new Intent(MainActivity.this, EditTask.class);
            clickedTask=(Task)view.getTag();
            startActivity(editActivity);
        }
    };
}
