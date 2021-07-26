package com.training.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
Intent intent1=getIntent();
String display_msg=intent1.getStringExtra(MainActivity.msg_id);
        EditText et=findViewById(R.id.displayText);
        et.setText(display_msg);
    }
    public void goHome(View view){
        Toast.makeText(this, "Make new note", Toast.LENGTH_SHORT).show();
        Intent intent2=new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}