package com.example.evi.mobtest;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private ImageButton youtube,fb,weather,map,calls,profile,alarm,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        youtube= (ImageButton) findViewById(R.id.youtube);
        fb=(ImageButton) findViewById(R.id.facebook);
        weather=(ImageButton) findViewById(R.id.weather);
        map=(ImageButton)findViewById(R.id.xartis);
        calls=(ImageButton)findViewById(R.id.katalogos);
       profile=(ImageButton)findViewById(R.id.profile);
        alarm=(ImageButton)findViewById(R.id.alarm);
        back=(ImageButton)findViewById(R.id.returdn);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Youtube2.class);
                //  intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Facebook.class);
                //  intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, WeatherActivity.class);
                //  intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Notification.class);
                //  intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

   map.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Menu.this, MapsActivity.class);
            //  intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    });
    calls.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Menu.this, Friends.class);
            //  intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    });
       profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username="icsd";
                final String poli="samos";
                final String category="amea";
                Intent intent = new Intent(Menu.this, UserProfile.class);
                intent.putExtra("message",username);
                intent.putExtra("message1",poli);
                intent.putExtra("message2",category);
                //  intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

     }
    public void Return(View v){
        super.onBackPressed();
    }
}
