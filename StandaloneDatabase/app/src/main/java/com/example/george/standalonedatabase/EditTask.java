package com.example.george.standalonedatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditTask extends Activity {
    EditText mTitle, mDesc, mDate, mTime;
    Spinner mPriority;
    Button mEdit;
    DatabaseManager mDb;
    Task currentTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        // Get the task
        currentTask = MainActivity.clickedTask;
        mTitle = (EditText) findViewById(R.id.editTitle);
        mDesc = (EditText)findViewById(R.id.editDescription);
        mDate = (EditText) findViewById(R.id.editDate);
        mTime = (EditText) findViewById(R.id.editTime);
        mPriority=(Spinner)findViewById(R.id.spinner);
        mEdit=(Button)findViewById(R.id.taskEditer);
        mDb = new DatabaseManager(this);
        // Construct the fields in the XML file
        mTitle.setText(currentTask.getTitle());
        mDesc.setText(currentTask.getDescription());
        mDate.setText(currentTask.getDate());
        mTime.setText(currentTask.getTime());
        // Set the text of the fields to the given values in the Task
        // Add the done button to make changes into the task which redirects into the main activity again
        // Edit the data in the database and nullify the clicked task
    }

    public void editTask(View v)
    {
        currentTask.setTitle(mTitle.getText().toString());
        currentTask.setDescription(mDesc.getText().toString());
        currentTask.setDate(mDate.getText().toString());
        currentTask.setTime(mTime.getText().toString());
        mDb.editTaskById(currentTask);
        currentTask=null;
        MainActivity.clickedTask=null;
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
