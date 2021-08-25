package com.example.walkthroughscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingSreen extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button next_btn,next_arrow;

    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding_sreen);

        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.dots_ll);
        next_btn = findViewById(R.id.next_btn);
        next_arrow = findViewById(R.id.next_arrow);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    //skip method
    public void skip(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    //next method
    public void next(View view) {
        viewPager.setCurrentItem(currentPosition + 1);
    }

    public void next_btn(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


    private void addDots(int position) {

        //3 is the number of slides o onBoarding screen
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.black));
        }

    }


    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;

            //to show the button at the end
            if (position == 0) {
                next_btn.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                next_btn.setVisibility(View.INVISIBLE);
            } /*else if (position == 2) {
                next_btn.setVisibility(View.INVISIBLE);
            }*/ else {
                next_btn.setVisibility(View.VISIBLE);
                next_arrow.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}