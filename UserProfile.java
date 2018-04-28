package com.example.evi.mobtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class UserProfile extends Activity {
        private TextView txt,txt1,txt2,txt3;
        private ImageButton settings1,settings2;
        Button menu;

        private Button sendcomments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        txt = (TextView) findViewById(R.id.textView2);
        txt1 = (TextView) findViewById(R.id.textView10);
        txt2 = (TextView) findViewById(R.id.textView12);
        txt3 = (TextView) findViewById(R.id.textView14);
        sendcomments = (Button) findViewById(R.id.button10);
        menu = (Button) findViewById(R.id.button12);



        txt1.setText(getIntent().getExtras().getString("message"));
        txt2.setText(getIntent().getExtras().getString("message1"));
        txt3.setText(getIntent().getExtras().getString("message2"));

        settings1=(ImageButton)findViewById(R.id.setting1);
        settings2=(ImageButton)findViewById(R.id.setting2);
        settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, InitializeSettings.class);
                startActivity(intent);
            }
        });

        settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, Updates.class);
                startActivity(intent);
            }
        });
       menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, Menu.class);
                startActivity(intent);
            }
        });
        sendcomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, SendComment.class);
                startActivity(intent);
            }
        });

    }
    public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove("usernameKey");
        editor.remove("PassKey");
        editor.apply();
        Intent i = new Intent(UserProfile.this, MainActivity.class);

          startActivity(i);
    }

    public void close(View view){
        finish();
    }
}
