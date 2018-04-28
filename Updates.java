package com.example.evi.mobtest;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Updates extends AppCompatActivity {
 private Button back,update;
    private EditText uname,namee,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        back= (Button)findViewById(R.id.button8);
        update= (Button)findViewById(R.id.button7);

        namee=(EditText)findViewById(R.id.editText11);
        uname=(EditText)findViewById(R.id.editText13);
        pw=(EditText)findViewById(R.id.editText14);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final  String username=namee.getText().toString();
             final   String email=uname.getText().toString();
                String password=pw.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent=new Intent(Updates.this,UserProfile.class);
                                intent.putExtra("message",username);
                                intent.putExtra("message3",email);
                                Updates.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(Updates.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                UpdateRequest updateRequest=new UpdateRequest(username,email,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Updates.this);
                queue.add(updateRequest);

            }
        });
    }
    public void ReturnHome(View v){
        super.onBackPressed();
    }
}
//dieuthinsi
