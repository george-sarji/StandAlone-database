package com.example.george.standalonedatabase;

import android.app.Activity;
import android.os.Bundle;

public class EditTask extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        // Get the task
        Task clickedTask = MainActivity.clickedTask;
        // Construct the fields in the XML file
        // Set the text of the fields to the given values in the Task
        // Add the done button to make changes into the task which redirects into the main activity again
        // Edit the data in the database and nullify the clicked task
    }
}
