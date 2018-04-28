package com.example.evi.mobtest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.evi.mobtest.Model.Weather;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken ;
    private final static String TAG = MainActivity.class.getName().toString();
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username = "usernameKey";
    public static final String Pass = "PassKey";
    SharedPreferences sharedpreferences;

    private EditText passwordd;
    private EditText emaill;
    private Button b1Login;
    private Button b2Login;
    private Button registerlink;
    private RequestQueue requestQueue;
    private StringRequest request;
    private ImageView imageView;
    private  Intent i,j;
    private  TextView tx;
    // b1=(Button)findViewById(R.id.button2)
    //public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext(), new FacebookSdk.InitializeCallback() {
            @Override
            public void onInitialized() {
                accessToken = AccessToken.getCurrentAccessToken();
                if (accessToken == null) {
                    Log.d(TAG, "not log in yet");
                } else {
                    Log.d(TAG, "Logged in");
                   // Intent main = new Intent(MainActivity.this,MainActivity.class);
                   // startActivity(main);

                }
            }
        });
        setContentView(R.layout.activity_main);

        AppEventsLogger.activateApp(this);
        callbackManager=CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                accessToken = newToken;
            }};
       // b1=(Button)findViewById(R.id.button2);
        setContentView(R.layout.activity_main);

        b1Login= (Button) findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);



        registerlink=(Button) findViewById(R.id.button4);
        emaill=(EditText)findViewById(R.id.editText);
        passwordd=(EditText)findViewById(R.id.editText2);

        loginButton=(LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email"));

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
//Once authorized from facebook will directly go to MainActivity
                        accessToken = loginResult.getAccessToken();
                        //ALLAGI -->FACEBOOK
                        Intent main = new Intent(MainActivity.this,Updates.class);
                        startActivity(main);                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Toast.makeText(getApplicationContext(),"CANCEL",Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                  });

        b1Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String email= emaill.getText().toString();
               final String password=passwordd.getText().toString();
                final String mes="Samos";
                final SharedPreferences.Editor editor = sharedpreferences.edit();

                Response.Listener<String > responseListener=new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Μόλις κάνατε είσοδο").show();
                                editor.putString(Username, email);

                                editor.putString(Pass,password );
                                editor.commit();


                            Intent intent = new Intent(MainActivity.this, UserProfile.class);
                            intent.putExtra("message",email);
                             intent.putExtra("message3",mes);
                             startActivity(intent);
// Menu
                            }else{

                                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Αποτυχία Εισόδου")
                                        .setNegativeButton("Προσπαθήστε Ξανά",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest=new LoginRequest(email,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
               queue.add(loginRequest);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        accessTokenTracker.stopTracking();
    }


    public  void Reg(View view){
    Intent intent = new Intent(this, SignUpActivity.class);
    startActivity(intent);
}

}






