package com.example.george.standalonedatabase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTask extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

    }
    public void addTask(View v) {
        DatabaseManager mDb = new DatabaseManager(this);
        EditText mTitle = (EditText) findViewById(R.id.editTitle);
        EditText mDesc = (EditText) findViewById(R.id.editDescription);
        EditText mDate = (EditText) findViewById(R.id.editDate);
        EditText mTime = (EditText) findViewById(R.id.editTime);
        Spinner mPriority = (Spinner) findViewById(R.id.spinner);

        if (mTime.getText().toString() == "" || mDesc.getText().toString() == "" || mDate.getText().toString() == "" || mTime.getText().toString() == "" || mPriority.getSelectedItem() == null) {
            String missing = "";
            if(mTitle.getText().toString()=="") {
                missing+="Title\n";
            }
            if(mDesc.getText().toString()=="") {
                missing+="Description\n";
            }
            if(mDate.getText().toString()=="") {
                missing+="Date\n";
            }
            if(mTime.getText().toString()=="") {
                missing += "Time\n";
            }
            if(mPriority.getSelectedItem()==null) {
                missing += "Priority\n";
            }
            AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
            mDialog.setTitle("Missing items!");
            mDialog.setMessage("Missing items:\n"+missing);
            mDialog.setCancelable(true);
            mDialog.show();
        }
        else {
            // Everything is filled per request; file task in.
            mDb.AddTask(mTitle.getText().toString(), mDesc.getText().toString(), mDate.getText().toString(), mTime.getText().toString(), mPriority.getSelectedItem().toString(), new byte[0], "False");
            // Show toast that operation is successful
            Toast.makeText(this, "Operation successful!", Toast.LENGTH_LONG).show();
            Intent startPage = new Intent(this, MainActivity.class);
            startActivity(startPage);
            finish();
        }
    }
}
