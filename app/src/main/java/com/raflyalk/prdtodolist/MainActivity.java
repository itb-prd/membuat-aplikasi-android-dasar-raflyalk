package com.raflyalk.prdtodolist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;

import static android.R.attr.button;
import static android.R.attr.value;
import static com.raflyalk.prdtodolist.R.id.floatingActionButton;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> toDoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(toDoAdapter);

        String pesan = getIntent().getStringExtra("pesan");
        //Toast.makeText(this,pesan,Toast.LENGTH_LONG).show();

    }

    public void sendMessage(View view){
        Intent intent = new Intent(view.getContext(), TambahActivity.class);
        startActivity(intent);

    }


}
