package com.training.imageextract;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Uri> uriList;
    GridView grid;
    ContentResolver c_resolver;
    Cursor m_cursor;
    Uri imageUri;
    private final int READ_PERMISSION_CODE=1;
    private String[] m_columnProjection=new String[]{MediaStore.Images.Media._ID};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uriList=new ArrayList<>();
        grid=findViewById(R.id.gridView);
    }
    public void showImage(View view){
        // check if the permission is already given
        if ((ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) == (PackageManager.PERMISSION_GRANTED)) {
            performActivity();
        }
        else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PERMISSION_CODE);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                performActivity();
            }
        }

    }
    public void performActivity(){
        c_resolver=getContentResolver();
        m_cursor= c_resolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,m_columnProjection,null,null,null);
        if(m_cursor!=null&&m_cursor.getCount()>=0){
            while(m_cursor.moveToNext()){
                long id= m_cursor.getLong(0);
                imageUri= ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,id);
                uriList.add(imageUri);
            }
        }
        grid.setAdapter(new GridAdapter(uriList,this));
    }



}