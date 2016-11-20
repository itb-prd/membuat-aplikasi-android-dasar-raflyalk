package com.raflyalk.prdtodolist;

import android.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

/**
 * Created by rafly on 11/20/2016.
 */

public class edit extends DialogFragment{
    int mNum;
    String zName;

    static edit newInstance(int num, String todo) {
        edit f = new edit();

        Bundle args = new Bundle();
        args.putInt("num",num);
        args.putString("name",todo);

        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNum = getArguments().getInt("num");
        zName = getArguments().getString("name");

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage(Html.fromHtml("Apa yang ingin Anda lakukan dengan to do <b>'"+zName+"'</b> ?"))
                .setPositiveButton("UBAH",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent getNewNameIntent = new Intent(getActivity(), editScreen.class);

                        final int result = 1;
                        getNewNameIntent.putExtra("Index of ToDoList", mNum);
                        getNewNameIntent.putExtra("Name of ToDoList", zName);

                        getActivity().startActivityForResult(getNewNameIntent, result);

                    }
                })
                .setNegativeButton("HAPUS",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent deleteIntent = new Intent(getActivity(), delete.class);
                        final int result = 3;
                        deleteIntent.putExtra("Index of ToDoList", mNum);

                        getActivity().startActivityForResult(deleteIntent, result);

                    }
                })
                .create();
    }
}
