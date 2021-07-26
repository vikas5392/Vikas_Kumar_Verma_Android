package com.training.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    TextView time_TextView;
    private final SimpleDateFormat WatchTime = new SimpleDateFormat("HH:mm");
    private static BroadcastReceiver receiver;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time_TextView=findViewById(R.id.timeText);
        time_TextView.setText(WatchTime.format(new Date()));

        receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              if(intent.getAction().compareTo(Intent.ACTION_TIME_TICK)==0){
                  time_TextView.setText(WatchTime.format(new Date()));

              }
            }
        };
registerReceiver(receiver,new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(receiver!=null)
            unregisterReceiver(receiver);

    }
}