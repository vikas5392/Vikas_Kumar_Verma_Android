package com.training.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.training.todo.Params.DB_NAME;
import static com.training.todo.Params.DB_VERSION;
import static com.training.todo.Params.ENTRY;
import static com.training.todo.Params.ID;
import static com.training.todo.Params.TABLE_NAME;

public class DB_Handler extends SQLiteOpenHelper {

    public DB_Handler(@Nullable  Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryToCreate="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY,"+ENTRY+" TEXT)";
        db.execSQL(queryToCreate);
    }
    public void addEntry(Data data){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ENTRY,data.getEntry());
        db.insert(TABLE_NAME,null,values);

    }
    public ArrayList<Data> getEntry(){

        ArrayList<Data> EntryList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(select,null);
        if (cursor.moveToFirst()) {
            do {
                Data dataDisplay = new Data();
                dataDisplay.setId(Integer.parseInt(cursor.getString(0)));
                dataDisplay.setEntry(cursor.getString(1));
                EntryList.add(dataDisplay);
            } while (cursor.moveToNext());
        }
        return EntryList;
    }
   /* public List<String> getEntry() {
        List<String> EntryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                EntryList.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }

   return EntryList;
    }*/
    public void deleteEntry() {

        SQLiteDatabase db = this.getWritableDatabase();

      // db.execSQL("delete from "+ TABLE_NAME);
       db.delete("TABLE_NAME",null,null);
       // db.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
