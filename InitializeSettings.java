package com.example.evi.mobtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InitializeSettings extends AppCompatActivity {
    private EditText ed1,ed2,ed3;
    private  TextView  txt1,txt2,txt3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize_settings);
        button=(Button)findViewById(R.id.button6);

        ed1=(EditText) findViewById(R.id.editText8);
        ed2=(EditText) findViewById(R.id.editText9);
        ed3=(EditText) findViewById(R.id.editText10);


        txt1=(TextView) findViewById(R.id.textView5);


      final  Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.social_groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1=(EditText) findViewById(R.id.editText8);
                String name= ed1.getText().toString();
                String city =ed2.getText().toString();
                String address= ed3.getText().toString();

               Intent i =new Intent(InitializeSettings.this,UserProfile.class);
                i.putExtra("message",ed1.getText().toString() );
                i.putExtra("message1",ed2.getText().toString() );
                i.putExtra("message2",ed3.getText().toString() );
                i.putExtra("message3", spinner.getSelectedItem().toString());
                startActivity(i);
              //  txt2.setText(city);
                //txt3.setText(address);

            }
        });
    }
    public void ReturnHome(View v){
        super.onBackPressed();
    }

}
