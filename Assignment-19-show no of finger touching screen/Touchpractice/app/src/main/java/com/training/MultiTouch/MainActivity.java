package com.training.MultiTouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ConstraintLayout constraintLay;
TextView resultText;
int touchType;
int countPointerUp,countPointerDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLay=findViewById(R.id.main_Layout);
        resultText=findViewById(R.id.touchNo);
        constraintLay.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               // Log.i("touchEvents","Touch detected");

            touchType=event.getActionMasked();

            switch(touchType){
                //Single touch
                case MotionEvent.ACTION_DOWN:
                    Log.i("touchEvents","Touch down");
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("touchEvents","Touch UP");
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("touchEvents","Moving");
                    break;
                    //Multi touch
                case MotionEvent.ACTION_POINTER_DOWN:
                    Log.i("touchEvents","Action pointer down");
                    countPointerDown=event.getPointerCount();
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    Log.i("touchEvents","Action pointer UP");
                    countPointerUp=event.getPointerCount();
                    break;

            }
                resultText.setText("No of finger touching down: "+countPointerDown+"\n"+"No of finger touching up: "+countPointerUp);

                return true;
            

            }
        });
    }
}