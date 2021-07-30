package com.training.multiplewidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void image(View view){
        Toast.makeText(this, "Image view", Toast.LENGTH_SHORT).show();
    }
    public void button(View view){
        Toast.makeText(this, "Button view", Toast.LENGTH_SHORT).show();
    }
    public void imageButton(View view){
        Toast.makeText(this, "image button", Toast.LENGTH_SHORT).show();
    }
    public void text(View view){
        Toast.makeText(this, "Text view", Toast.LENGTH_SHORT).show();
    }
    public void radio(View view){
        Toast.makeText(this, "radio button", Toast.LENGTH_SHORT).show();
    }
}