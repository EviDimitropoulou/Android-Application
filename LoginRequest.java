package com.example.evi.mobtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evi on 12/29/2016.
 */

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQ_URL="http://192.168.1.5/project/newLogin.php";
    private Map<String,String> params;
    public LoginRequest( String email, String password, Response.Listener<String>listener){
        super(Method.POST,LOGIN_REQ_URL,listener,null);
        params=new HashMap<>();

        params.put("email",email);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
