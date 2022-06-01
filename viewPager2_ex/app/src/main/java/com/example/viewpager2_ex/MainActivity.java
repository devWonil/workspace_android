package com.example.viewpager2_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2_ex.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add("https://cdn.pixabay.com/photo/2021/08/25/18/43/flower-6574241__480.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/07/27/13/40/woman-6496881__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/05/15/19/13/flower-4205744__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/18/15/44/apple-7205616__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/12/13/04/fresh-strawberries-7191555__340.jpg");

        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);
        sliderImageViewPager = findViewById(R.id.sliderViewPager2);

        sliderImageViewPager.setOffscreenPageLimit(2);
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));
        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.size());
    }

    private void setupIndicators(int count){
        ImageView[] indicators = new ImageView[count];

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i <indicators.length; i++){
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicatorsContainer.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int position){
        int childCount = layoutIndicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);
            if(i == position){
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_inactive));
            }
        }
    }
}