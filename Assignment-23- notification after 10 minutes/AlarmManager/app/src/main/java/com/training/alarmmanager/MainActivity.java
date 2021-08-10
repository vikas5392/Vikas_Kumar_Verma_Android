package com.training.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        //create intent to go to the alarmreciever class
        Intent intent=new Intent(this,AlarmReciever.class);
        PendingIntent pIntent=PendingIntent.getBroadcast(this.getApplicationContext(),1,intent,0);
        //get the alarm manager
        AlarmManager a_manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        a_manager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+600000,pIntent);
        Toast.makeText(this, "Notification in 10 minutes", Toast.LENGTH_SHORT).show();
    }

    public static final String channel1ID = "channel1_ID";

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    channel1ID, "channel1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel1");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel1);
        }
    }

}