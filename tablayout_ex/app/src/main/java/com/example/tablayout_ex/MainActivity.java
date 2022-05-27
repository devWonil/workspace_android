package com.example.tablayout_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tablayout_ex.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final int TAB_COUNT = 3;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyPagerAdapter myPagerAdapter;
    private String tabName[] = {"ONE", "TWO", "THREE"};

    private void initData(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        for (String name : tabName){
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), TAB_COUNT);
    }

    private void addEventListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); // 0, 1, 2
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

        viewPager.setAdapter(myPagerAdapter);
        // 뷰 페이저와 Tab 연동
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}