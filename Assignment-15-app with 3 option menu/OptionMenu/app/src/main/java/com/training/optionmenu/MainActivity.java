package com.training.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.menu_demo,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.apple:
                Toast.makeText(this, "Fruits:Apple", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(this, "Fruits:Banana", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mango:
                Toast.makeText(this, "Fruits:Mango", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.inception:
                Toast.makeText(this, "Movies:Inception", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.justiceLeague:
                Toast.makeText(this, "Movie:Justice League", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.endGame:
                Toast.makeText(this, "Movie:End Game", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.close:
                finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}