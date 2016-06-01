package com.example.ayush.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ayush on 25/5/16.
 */
public class Get_OTP extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.get_otp);
        button =(Button)findViewById(R.id.signUp1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Get_OTP.this, OTP_Verification.class);
                startActivity(intent);

            }
        });

    }
}