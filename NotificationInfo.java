package com.example.evi.mobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class NotificationInfo extends AppCompatActivity {
    EditText Notif_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_info);

        Notif_Text = (EditText) findViewById(R.id.Notif_Text);

        Notif_Text.setText(Notification.message.getText().toString());
        Notif_Text.setKeyListener(null);
    }
}
