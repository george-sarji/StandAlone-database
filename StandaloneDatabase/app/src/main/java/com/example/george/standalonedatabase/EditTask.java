package com.example.george.standalonedatabase;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class EditTask extends Activity {
    EditText mTitle, mDesc, mDate, mTime;
    Spinner mPriority;
    Button mEdit;
    DatabaseManager mDb;
    Task currentTask;
    ImageView mImage;
    CheckBox mCb;
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
        mImage=(ImageView)findViewById(R.id.imageView);
        mCb = (CheckBox)findViewById(R.id.doneBox);

        mDb = new DatabaseManager(this);
        // Construct the fields in the XML file
        mTitle.setText(currentTask.getTitle());
        mDesc.setText(currentTask.getDescription());
        mDate.setText(currentTask.getDate());
        mTime.setText(currentTask.getTime());
        byte[] mByteArr = currentTask.getPhoto();
        switch (currentTask.getPriority()) {
            case("Urgent"): {
                mPriority.setSelection(0);
                break;
            }
            case("Normal"): {
                mPriority.setSelection(1);
                break;
            }
            case("Not needed"): {
                mPriority.setSelection(2);
                break;
            }
        }

        switch (currentTask.getDone())
        {
            case ("true"): {
                mCb.setChecked(true);
                break;
            }
            case ("false"):
            {
                mCb.setChecked(false);
                break;
            }
        }

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
        currentTask.setDone(mCb.isChecked()+"");
        currentTask.setPriority(mPriority.getSelectedItem().toString());
        mDb.editTaskById(currentTask);
        currentTask=null;
        MainActivity.clickedTask=null;
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    public void deleteTask(View v)
    {
        mDb.DeleteTaskById(currentTask.getId()+"");
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
