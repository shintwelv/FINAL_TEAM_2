package com.cookandroid.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSuccess extends AppCompatActivity {
    Button btnGoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocalActivity.class);
                startActivity(intent);
            }
        });
    }
}