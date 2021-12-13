package com.bkacad.nnt.notificationdemod01k11;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    "channel 1",
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(
                    "channel 2",
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 2");

            NotificationManager manager = this.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
