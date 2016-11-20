package com.raflyalk.prdtodolist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import static android.R.attr.button;
import static android.R.attr.value;
import static com.raflyalk.prdtodolist.R.id.floatingActionButton;
import static com.raflyalk.prdtodolist.R.id.listView;


public class MainActivity extends AppCompatActivity {

    public ArrayList<String> kontenToDo = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bacaFile();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getNewItemIntent = new Intent(v.getContext(), TambahActivity.class);
                final int result = 2;

                startActivityForResult(getNewItemIntent,result);
            }
        });

        displayDaftar();

    }

    protected void displayDaftar(){
        ListAdapter toDoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,kontenToDo);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(toDoAdapter);

        simpanFile();
    }

    protected void onActivityResult (int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 2 && data != null){

            kontenToDo.add(data.getExtras().getString("New Item"));

        }
        displayDaftar();
    }

    public String namaFile = "todolistfile.dat";
    private void bacaFile() {
        try{
            FileInputStream ins = new FileInputStream(new File(getFilesDir(),namaFile));
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));

            String todo;

            while ((todo = br.readLine()) != null){
                kontenToDo.add(todo);
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void simpanFile(){
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(getFilesDir(),namaFile)));
            for (String todo: kontenToDo){
                pw.println(todo);
            }
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
