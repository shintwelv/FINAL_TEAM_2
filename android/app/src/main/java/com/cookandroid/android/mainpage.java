package com.cookandroid.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator3;

public class mainpage extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 5;
    private CircleIndicator3 mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new MyAdapter(this, num_page);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        /**
         * 이 부분 조정하여 처음 시작하는 이미지 설정.
         * 2000장 생성하였으니 현재위치 1002로 설정하여
         * 좌 우로 슬라이딩 할 수 있게 함. 거의 무한대로
         */

        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(5); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });


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
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),mainpage.class);
                startActivity(intent);
            }
        });

        // 공지들 추가 버튼
        TextView Noticetitle = findViewById(R.id.Noticetitle);
        Noticetitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Notice.class);
                startActivity(intent);
            }
        });
        TextView localfestival = findViewById(R.id.localfestival);
        localfestival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LocalActivity.class);
                startActivity(intent);
            }
        });
        TextView FreeBoard = findViewById(R.id.FreeBoard);
        FreeBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Free.class);
                startActivity(intent);
            }
        });


//        Gallery gallery = (Gallery) findViewById(R.id.gallery);
//        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
//        gallery.setAdapter(galAdapter);
    }
//    public class MyGalleryAdapter extends BaseAdapter {
//
//        Context context;
//        Integer [] posterID = {
//                R.drawable.tt1, R.drawable.tt2,
//                R.drawable.tt3, R.drawable.tt4,
//                R.drawable.tt5
//        };
//
//        public MyGalleryAdapter(Context c) {
//            context = c;
//        }
//
//
//        @Override
//        public int getCount() {
//            return posterID.length;
//        }
//
//        @Override
//        public Object getItem(int arg0) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int postion, View convertView, ViewGroup parent) {
//            ImageView imageView = new ImageView(context);
//            imageView.setLayoutParams(new Gallery.LayoutParams(500, 600));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(5, 5, 5, 5);
//            imageView.setImageResource(posterID[postion]);
//
//            final int pos = postion;
//            imageView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    return false;
//                }
//            });
//
//            return imageView;
//        }
//    }
}
