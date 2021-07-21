package com.training.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.training.todo.Params.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
ArrayList<String> aList;
Button mButton;
EditText mText;
ListView lv;
DB_Handler db;
Data data;
String entry;
EditText et;
    ArrayList<String> entries;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DB_Handler(MainActivity.this);
        data=new Data();
        et=findViewById(R.id.editText);
        lv=findViewById(R.id.myList);
    }
    public void add(View view){
    entry=et.getText().toString();
    data.setEntry(entry);
    db.addEntry(data);
  entries=new ArrayList<>();
   ArrayList<Data> entry_data=db.getEntry();
for (Data data:entry_data){
    entries.add(data.getId()+" "+data.getEntry());
}
ArrayAdapter <String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,entries);

   lv.setAdapter(adapter);
    et.getText().clear();
}
public void delete(View view){
        entries.clear();
        }

}