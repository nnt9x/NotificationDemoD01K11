package com.bkacad.nnt.notificationdemod01k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnShow, btnDissmiss;
    private Notification notification, notification1, notification2;
    private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDissmiss = findViewById(R.id.btnDissmiss);
        btnShow = findViewById(R.id.btnShow);

        notificationManagerCompat  = NotificationManagerCompat.from(this);

        // Tạo notification
        notification = new NotificationCompat.Builder(this, "channel 1")
                .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                .setContentTitle("Thông báo")
                .setContentText("Bạn có thông báo mới từ ứng dụng Demo")
                .setGroup("group 1")
                .build();

        notification1 = new NotificationCompat.Builder(this, "channel 1")
                .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                .setContentTitle("Thông báo 1")
                .setContentText("Bạn có thông báo mới từ ứng dụng Demo 1")
                .setGroup("group 1")
                .build();


        Notification summaryNotification =
                new NotificationCompat.Builder(MainActivity.this, "channel 1")
                        .setContentTitle("Channel 1")
                        //set content text to support devices running API level < 24
                        .setContentText("Two notification")
                        .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("Alex Faarborg  Check this out")
                                .addLine("Jeff Chang    Launch Party")
                                .setBigContentTitle("2 new messages")
                                .setSummaryText("Bạn có 2 thông báo"))
                        //build summary info into InboxStyle template
                        .setGroup("group 1")
                        //set this notification as the summary for the group
                        .setGroupSummary(true)
                        .build();

        notification2 = new NotificationCompat.Builder(this, "channel 2")
                .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                .setContentTitle("Thông báo 2")
                .setContentText("Bạn có thông báo mới từ ứng dụng Demo 2")
                .build();


        btnDissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ẩn notification
                notificationManagerCompat.cancel(1);

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiện notification
                notificationManagerCompat.notify(1,notification);
                notificationManagerCompat.notify(2, notification1);
                notificationManagerCompat.notify(3, notification2);
                notificationManagerCompat.notify(0,summaryNotification);
            }
        });
    }
}