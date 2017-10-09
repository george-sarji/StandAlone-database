package com.example.george.standalonedatabase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class AddTask extends Activity {
    protected byte[] mImage;
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

        if (mTime.getText().toString().trim().isEmpty() || mDesc.getText().toString().trim().isEmpty()|| mDate.getText().toString().trim().isEmpty() || mTitle.getText().toString().trim().isEmpty()|| mPriority.getSelectedItem() == null) {
            String missing = "";
            if(mTitle.getText().toString().trim().isEmpty()) {
                missing+="Title\n";
            }
            if(mDesc.getText().toString().trim().isEmpty()) {
                missing+="Description\n";
            }
            if(mDate.getText().toString().trim().isEmpty()) {
                missing+="Date\n";
            }
            if(mTime.getText().toString().trim().isEmpty()) {
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
            mDb.AddTask(mTitle.getText().toString(), mDesc.getText().toString(), mDate.getText().toString(), mTime.getText().toString(), mPriority.getSelectedItem().toString(), mImage, "false");
            // Show toast that operation is successful
            Toast.makeText(this, "Operation successful!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    static final int REQUEST_IMAGE_CAPTURE = 24;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            mImage = stream.toByteArray();
        }
    }

    public void takePhoto(View v)
    {
        dispatchTakePictureIntent();
    }
}
