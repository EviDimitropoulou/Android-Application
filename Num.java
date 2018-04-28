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

public class Num extends AppCompatActivity {
    Button friends, num, call;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);

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
                Intent intent = new Intent(Num.this, Friends.class);
                Num.this.startActivity(intent);
            }
        });
        num = (Button) findViewById(R.id.num);

        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Num.this, Num.class);
                Num.this.startActivity(intent);
            }
        });

        call = (Button) findViewById(R.id.make_call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Num.this, Call.class);
                Num.this.startActivity(intent);
            }
        });

        ImageButton c = (ImageButton) findViewById(R.id.call9);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:100"));
                startActivity(i);
            }
        });

        ImageButton c2 = (ImageButton) findViewById(R.id.call10);

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:199"));
                startActivity(i);
            }
        });

        ImageButton c3 = (ImageButton) findViewById(R.id.call11);

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:184"));
                startActivity(i);
            }
        });
        ImageButton c4 = (ImageButton) findViewById(R.id.call12);

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:14944"));
                startActivity(i);
            }
        });

        ImageButton c5 = (ImageButton) findViewById(R.id.call13);

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:112"));
                startActivity(i);
            }
        });

        ImageButton c6 = (ImageButton) findViewById(R.id.call14);

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:1065"));
                startActivity(i);
            }
        });

        ImageButton c7 = (ImageButton) findViewById(R.id.call15);

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:166"));
                startActivity(i);
            }
        });

    }
}
