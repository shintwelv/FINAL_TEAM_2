package com.cookandroid.android;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class noticeboard5 extends AppCompatActivity implements OnMapReadyCallback{

    // 구글 맵 참조변수 생성
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;
    VideoView videoview;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_noticeboard5);

        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);
        TextView title = findViewById(R.id.toolbar_title);

        leftIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),menu.class);
                startActivity(intent);
            }
        });
        rightIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),member.class);
                startActivity(intent);
            }
        });

        Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LocalActivity.class);
                startActivity(intent);
            }
        });

        videoview = (VideoView) this.findViewById(R.id.video5);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoview);
        videoview.setMediaController(mc);
        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.t6));
        videoview.start();

        fragmentManager =getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.구글지도);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng location = new LatLng(33.24592103603507, 126.56491854021357);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("이중섭미술관");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

    }
}