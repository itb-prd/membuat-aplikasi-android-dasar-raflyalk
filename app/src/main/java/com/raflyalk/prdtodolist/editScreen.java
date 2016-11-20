package com.raflyalk.prdtodolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);

        EditText editText = (EditText) findViewById(R.id.tulisToDo);
        editText.setText(getIntent().getExtras().getString("Name of To Do List"));

    }

    public void sendNewItem(View view){
        EditText editText = (EditText) findViewById(R.id.tulisToDo);
        String newText = String.valueOf(editText.getText());
        int index = getIntent().getExtras().getInt("Index of To Do List");
        Intent goBack = new Intent();
        goBack.putExtra("New Item", newText);
        goBack.putExtra("Index To Do", index);
        setResult(RESULT_OK, goBack);

        finish();
    }
}