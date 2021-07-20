package com.training.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String msg_id="from 1 to 2";
EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit=findViewById(R.id.meditText);
    }
    public void goSave(View view){
        String textContent=mEdit.getText().toString();
        SharedPreferences preferences=getSharedPreferences("Notes",MODE_PRIVATE);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString("note1",textContent);
        edit.apply();
        if(textContent!=null){
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Note empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void doDisplay(View view){
        Intent intent1=new Intent(this,DisplayActivity.class);
SharedPreferences getPreference=getSharedPreferences("Notes",MODE_PRIVATE);
String display=getPreference.getString("note1","saved note will be displayed here");
intent1.putExtra(msg_id,display);
startActivity(intent1);

    }
}