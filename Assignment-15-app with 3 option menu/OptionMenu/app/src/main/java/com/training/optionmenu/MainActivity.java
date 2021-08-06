package com.training.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView list_V;
    ArrayList<String> fruitList;
    ArrayList<String> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_V=findViewById(R.id.listView);

        fruitList=new ArrayList<>();
        fruitList.add( "FRUITS");
        fruitList.add("banana");
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("pineapple");

       movieList=new ArrayList<>();
        movieList.add("MOVIES");
        movieList.add("Inception");
        movieList.add("Harry Potter");
        movieList.add("Avatar");
        movieList.add("Suicide Squad");

    }
   //finally convert the xml file ie menudemo to a view by inflater
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.menu_demo,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.fruits:
                ArrayAdapter<String> F_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruitList);
               list_V.setAdapter(F_adapter);

                return true;


            case R.id.movies:

                ArrayAdapter<String> m_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movieList);
                list_V.setAdapter(m_adapter);
                return true;

                case R.id.close:
                finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}