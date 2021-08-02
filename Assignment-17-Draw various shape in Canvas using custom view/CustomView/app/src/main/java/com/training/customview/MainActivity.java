package com.training.customview;
import com.training.customview.Views.CustomView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;




public class MainActivity extends AppCompatActivity {
CustomView cv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv = findViewById(R.id.custom_view);

    }
    public void swap(View view){
    cv.swapColor();
    }
}