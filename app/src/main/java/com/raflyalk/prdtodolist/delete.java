package com.raflyalk.prdtodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
/**
 * Created by rafly on 11/20/2016.
 */


public class delete extends AppCompatActivity {

    Intent lastIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "To Do dihapus", Toast.LENGTH_LONG).show();

        lastIntent = getIntent();

        int index = lastIntent.getExtras().getInt("Index of To Do List");

        Intent goBack = new Intent();
        goBack.putExtra("Index To Do",index);
        setResult(RESULT_OK, goBack);

        finish();
    }
}