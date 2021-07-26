package com.training.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView et;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.imageDescription);
        iv1=findViewById(R.id.imageview1);
    }
    public void describeImage1(View view){
        String desc="Image name:\n"+view.getResources().getResourceName(R.id.imageview1)+"\n"+
                "Image type:"+view.getResources().getResourceTypeName(R.id.imageview1);
        et.setText(desc);
    }
    public void describeImage2(View view){
        String desc="Image name:\n"+view.getResources().getResourceName(R.id.imageview2)+"\n"+
                "Image type:"+view.getResources().getResourceTypeName(R.id.imageview2);
        et.setText(desc);
    }
    public void describeImage3(View view){
        String desc="Image name:\n"+view.getResources().getResourceName(R.id.imageView3)+"\n"+
                "Image type:"+view.getResources().getResourceTypeName(R.id.imageView3);
        et.setText(desc);
    }
   /* public void describeImage4(View view){
        String desc="Image name:\n"+view.getResources().getResourceName(R.id.imageView4)+"\n"+
                "Image type:"+view.getResources().getResourceTypeName(R.id.imageView4);
        et.setText(desc);
    }*/
    public void describeImage5(View view){
        String desc="Image name:\n"+view.getResources().getResourceName(R.id.imageView5)+"\n"+
                "Image type:"+view.getResources().getResourceTypeName(R.id.imageView5);
        et.setText(desc);
    }
}