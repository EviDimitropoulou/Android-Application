package com.example.evi.mobtest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendComment extends AppCompatActivity {
EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_comment);

        Button email = (Button) findViewById(R.id.send);
email.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
msg=(EditText)findViewById(R.id.editText15);
String message=msg.getText().toString();
        sendEmail(message);
    }
});

    }
    protected  void  sendEmail(String message){
        String[] to = new String[]{"evi_dimitropoulou@yahoo.gr"};
        String subject= ("Σχόλια Εφαρμογής ");
        Intent emailIntent= new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,to);
        emailIntent.putExtra(Intent.EXTRA_TEXT,to);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));


    }
}
