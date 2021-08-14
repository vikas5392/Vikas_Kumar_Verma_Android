package com.training.extractcontacts;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<DataModel> al=new ArrayList<>();
    private int CONTACT_PERMISSION_CODE=1;
    ContentResolver c_resolver;
    Cursor m_cursor;
    String name;
    String number;
    String imageUri;
    private String[] m_columnProjection=new String[]{ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone.CONTACT_ID};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerView);
    }
    //on click event
    public void getContacts(View view){
        // check if the permission is already given
        if ((ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)) == (PackageManager.PERMISSION_GRANTED)) {
            performActivity();
        }
        else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, CONTACT_PERMISSION_CODE);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CONTACT_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                performActivity();
            }
        }

    }
    // if permission given what to perform
    public void performActivity(){
        c_resolver=getContentResolver();
        m_cursor=c_resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                m_columnProjection,
                null,null,null);

if(m_cursor!=null&& m_cursor.getCount()>=0) {
    while (m_cursor.moveToNext()) {
        name = m_cursor.getString(0);
        number = m_cursor.getString(1);
        long id=m_cursor.getLong(2);
       // imageUri=m_cursor.getString(2);
       // Uri uri=Uri.parse(imageUri);

        //to get uri
        Uri person = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,id);
       Uri finaluri=Uri.withAppendedPath(person, ContactsContract.Contacts.Photo.CONTENT_DIRECTORY);
       al.add(new DataModel(name, number,finaluri));
    }
}
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(al));
    }}