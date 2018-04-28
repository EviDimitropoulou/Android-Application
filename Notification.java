package com.example.evi.mobtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Notification extends AppCompatActivity {
    private  Button save, disable;
   private EditText time, date;

    private CheckBox single;
     private NotificationManager notificationManager;
    boolean is_notif_Active = false;
    public static EditText message;
    int not_id = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        save = (Button) findViewById(R.id.not_save_button);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetNotification();

                    Intent intent = new Intent(Notification.this, Menu.class);
                    Notification.this.startActivity(intent);
                }
            });

            disable = (Button) findViewById(R.id.not_disable_button);

            disable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StopNotification();

                    Intent intent = new Intent(Notification.this, MainActivity.class);
                    Notification.this.startActivity(intent);
                }
            });
        }

        public void SetNotification(){
            message = (EditText) findViewById(R.id.message);


            NotificationCompat.Builder notific_Builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setContentTitle("Notification").setContentText(message.getText().toString()).setTicker("Alert").setSmallIcon(R.drawable.ic_launcher);

            Intent intent = new Intent(this, NotificationInfo.class);

            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);

            taskStackBuilder.addParentStack(NotificationInfo.class);

            taskStackBuilder.addNextIntent(intent);

            PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

            notific_Builder.setContentIntent(pendingIntent);

            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(not_id, notific_Builder.build());

            is_notif_Active = true;
        }

        public void StopNotification(){
            if (is_notif_Active){
                notificationManager.cancel(not_id);
            }
        }
    }

