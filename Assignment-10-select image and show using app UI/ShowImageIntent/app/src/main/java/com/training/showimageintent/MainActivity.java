package com.training.showimageintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE=102;
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
    }
    public void getImage(View view){
        Intent i=new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        //we are sending this request and asking for some result
        startActivityForResult(Intent.createChooser(i,"Select Image"),GALLERY_REQUEST_CODE);
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
   if(requestCode==GALLERY_REQUEST_CODE){
       Uri image_uri=data.getData();
       iv.setImageURI(image_uri);
   }

    }
}