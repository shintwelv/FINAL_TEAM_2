package com.cookandroid.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class member extends AppCompatActivity {

    private ImageView memberclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        memberclose = (ImageView)findViewById(R.id.memberclose);

        memberclose.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });



        TextView Profile = findViewById(R.id.Profile);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Notice.class);
                startActivity(intent);
            }
        });
        TextView Login = findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
        TextView Sign = findViewById(R.id.Sign);
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
//        TextView Logout = findViewById(R.id.Logout);
//        Logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), LocalActivity.class);
//                startActivity(intent);
//            }
//        });


    }
}