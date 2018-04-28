package com.example.evi.mobtest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Friends extends AppCompatActivity {

    Button friends, num, call;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        if (ContextCompat.checkSelfPermission(this,
               android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CALL_PHONE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        }
        friends = (Button) findViewById(R.id.fr);

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friends.this, Friends.class);
                Friends.this.startActivity(intent);
            }
        });

        num = (Button) findViewById(R.id.num);

        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friends.this, Num.class);
                Friends.this.startActivity(intent);
            }
        });
        call = (Button) findViewById(R.id.make_call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friends.this, Call.class);
                Friends.this.startActivity(intent);
            }
        });

        ImageButton c = (ImageButton) findViewById(R.id.call);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6912345678"));
                startActivity(i);
            }
        });
        ImageButton c2 = (ImageButton) findViewById(R.id.call2);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6912345678"));
                startActivity(i);
            }
        });

        ImageButton c3 = (ImageButton) findViewById(R.id.call3);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6912345678"));
                startActivity(i);
            }
        });

        ImageButton c4 = (ImageButton) findViewById(R.id.call4);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6912345678"));
                startActivity(i);
            }
        });

        ImageButton c5 = (ImageButton) findViewById(R.id.call5);

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6912345678"));
                startActivity(i);
            }
        });
    }
}
