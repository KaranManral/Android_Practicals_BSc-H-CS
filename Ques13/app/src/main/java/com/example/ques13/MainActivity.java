package com.example.ques13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText.getText().toString();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationChannel notificationChannel = new NotificationChannel("1","Ques13", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel);
                Notification.Builder builder = new Notification.Builder(MainActivity.this,"1");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground).setContentText(msg).setContentTitle("Notification Message");
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(1,builder.build());
            }
        });
    }
}