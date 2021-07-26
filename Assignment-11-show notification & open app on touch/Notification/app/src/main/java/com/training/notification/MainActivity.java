package com.training.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    public static final int unique_id = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        //when i open a notification it will delete the display from top system status bar
        notification.setAutoCancel(true);
    }

    public void getNotification(View view) {
        notification.setSmallIcon(R.drawable.ic_baseline_adb_24);
        notification.setTicker("new Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Title");
        notification.setContentText("I am the body text");
        //when the notification is clicked, where we wanna go. in our example we go to home screen of our app
        Intent i = new Intent(this, MainActivity.class);
        //maybe the notification takes us to some other app, so we have to give the intent the permission to go anywhere
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //now as the notification structure is build, we wanna send it to the device
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(unique_id, notification.build());

    }
}