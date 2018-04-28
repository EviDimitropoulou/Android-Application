package com.example.evi.mobtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evi on 12/23/2016.
 */

public class RegisterReq extends StringRequest{

private static final String REGISTER_REQ_URL="http://192.168.1.5/project/new.php";
private Map<String,String> params;
public RegisterReq(String username, String email, String town,String password, String birthdate, String category, Response.Listener<String>listener){
    super(Method.POST,REGISTER_REQ_URL,listener,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("email",email);
        params.put("town",town);
        params.put("password",password);

        params.put("birthdate",birthdate);
        params.put("category",category);
        }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
