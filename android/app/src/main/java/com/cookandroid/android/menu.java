package com.cookandroid.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {

    private ImageView menuclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuclose = (ImageView)findViewById(R.id.menuclose);
        menuclose.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        TextView Noticebutton = findViewById(R.id.Noticebutton);
        Noticebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Notice.class);
                startActivity(intent);
            }
        });

        TextView LocalFestivalbutton = findViewById(R.id.LocalFestivalbutton);
        LocalFestivalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocalActivity.class);
                startActivity(intent);
            }
        });

        TextView FestivalReviewbutton = findViewById(R.id.FestivalReviewbutton);
        FestivalReviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Festival_review.class);
                startActivity(intent);
            }
        });
        TextView FreeBoardbutton = findViewById(R.id.FreeBoardbutton);
        FreeBoardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Free.class);
                startActivity(intent);
            }
        });
        TextView qa = findViewById(R.id.qa);
        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Qa.class);
                startActivity(intent);
            }
        });

    }
}