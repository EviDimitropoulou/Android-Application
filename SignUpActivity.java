package com.example.evi.mobtest;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {
    EditText uname,emai,pw,bd,cat,city;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        uname=(EditText)findViewById(R.id.editText3);
        emai=(EditText)findViewById(R.id.editText4);
        pw=(EditText)findViewById(R.id.editText5);
        bd=(EditText)findViewById(R.id.editText6);
        cat=(EditText)findViewById(R.id.editText7);
        city=(EditText)findViewById(R.id.poli) ;
        b=(Button)findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 final String username=uname.getText().toString();
                final String email=emai.getText().toString();
                final  String password=pw.getText().toString();
               final  String birthdate=bd.getText().toString();
               final  String category=cat.getText().toString();
               final String townn=city.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");


                            if(success){
                                //na to allaksw se UserProfile
                                Intent intent=new Intent(SignUpActivity.this,UserProfile.class);
                                intent.putExtra("message",username);
                                intent.putExtra("message1",townn);
                                intent.putExtra("message2",category);
                                SignUpActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(SignUpActivity.this);
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
                RegisterReq registerReq=new RegisterReq(username,email,townn,password,birthdate,category,responseListener);
                RequestQueue queue= Volley.newRequestQueue(SignUpActivity.this);
                queue.add(registerReq);
            }
        });
    }
    public void ReturnHome(View v){
        super.onBackPressed();
    }


}
