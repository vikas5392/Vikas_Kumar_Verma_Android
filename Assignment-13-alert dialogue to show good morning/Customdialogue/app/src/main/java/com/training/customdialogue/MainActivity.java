package com.training.customdialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getDialogue(View view){
        //to build teh dialogue
        AlertDialog.Builder buildDialogue=new AlertDialog.Builder(MainActivity.this);
        //to make view of the custom dialogue layout
        View customView=getLayoutInflater().inflate(R.layout.custom_dialogue_layout,null);
        buildDialogue.setView(customView);

        AlertDialog dialog=buildDialogue.create();
        dialog.show();
    }
}