package com.training.alarmmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Context.NOTIFICATION_SERVICE;
import static android.provider.Settings.System.getString;
import static androidx.core.content.ContextCompat.getSystemService;

public class AlarmReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder notification1 = new NotificationCompat.Builder(context, MainActivity.channel1ID);
        notification1.setSmallIcon(R.drawable.ic_launcher_foreground);
        notification1.setTicker("Greetings");
        notification1.setWhen(System.currentTimeMillis());
        notification1.setContentTitle("Message");
        notification1.setContentText("Hello!!");
        notification1.setAutoCancel(true);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification1.build());

        Intent intent1 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        notification1.setContentIntent(pendingIntent);
        //now as the notification structure is build, we wanna send it to the device
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2,notification1.build());

    }

}
