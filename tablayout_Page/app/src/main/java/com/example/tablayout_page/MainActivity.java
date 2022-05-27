package com.example.tablayout_page;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tablayout_page.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/*
 *   pager
 *   - 화면 (종이 넘기듯이 화면을 넘겨주는 역할)
 *   - Adapter
 *
 *   TabLayout
 *   - tab 을 담당하는 역할
 *   보통 같이 작성을 하지만 따로따로 만들어도 상관이 없다.
 *
 *   리스너
 *   pager 와 TabLayout 을 연결해주기 위해 필요하다.
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final int TAB_COUNT = 3;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyPagerAdapter myPagerAdapter;
    private String tabName[] = {"One", "Two", "Three"};

    private void initData(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
//        tabLayout.addTab(tabLayout.newTab().setText("One"));
//        tabLayout.addTab(tabLayout.newTab().setText("Two"));
//        tabLayout.addTab(tabLayout.newTab().setText("Three"));
        for (String name : tabName){
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), TAB_COUNT);
    }

    private void addEventListener(){
        // 1번탭에서 2번탭 진행 했을 때 (1번탭 사라질 때 뭔가 해야 될 일이 있다면
        // 새로운 탭이 선택 되었을 때 onTabSelected에서 코드를 작성하면 된다.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); // 0, 1, 2
                //Log.d(TAG, "[onTabSelected] : position : " + position);
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
//                Log.d(TAG, "[onTabUnSelected] : position : " + position);
            }

            // 먼저 활성화 되어잇는거 누르면
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
//                Log.d(TAG, "[onTabReselected] : position : " + position);
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

