package com.raflyalk.prdtodolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Button tombol = (Button) findViewById(R.id.button);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent();
                EditText editText = (EditText) findViewById(R.id.tulisToDo);
                String message = String.valueOf(editText.getText());
                goBack.putExtra("tambah_konten", message);
                setResult(RESULT_OK, goBack);
                finish();
            }
        });
    }

    public void sendNewItem(View view){
        EditText editText = (EditText) findViewById(R.id.tulisToDo);
        String newText = String.valueOf(editText.getText());

        Intent goBack = new Intent();
        goBack.putExtra("New Item", newText);
        setResult(RESULT_OK, goBack);

        finish();
    }
}