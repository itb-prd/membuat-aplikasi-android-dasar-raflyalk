package com.raflyalk.prdtodolist;

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
    }

    public void kirimData(View v){

        Intent intentt = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.tombol);
        String message = editText.getText().toString();
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        intentt.putExtra("pesan", message);
        startActivity(intentt);
    }
}