package com.example.carrot_market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.carrot_market.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        addBottomNavigationListener();
        replaceFragment(FragmentType.MY_INFO);
    }

    private void replaceFragment(FragmentType type){
        // 플래그먼트 5개 생성
        // 플래그먼트 매니저
        // 플래그먼트 트랜잭션
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.HOME){
            fragment = new FragmentHome();
        }else if (type == FragmentType.NEIGHBOR){
            fragment = new FragmentNeighbor();
        }else if (type == FragmentType.MY_LOCATION){
            fragment = new FragmentMyLocation();
        }else if(type == FragmentType.CHAT){
            fragment = new FragmentChat();
        }else {
            fragment = new FragmentMyInfo();
        }
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_neighbor:
                    replaceFragment(FragmentType.NEIGHBOR);
                    break;
                case R.id.page_my_location:
                    replaceFragment(FragmentType.MY_LOCATION);
                    break;
                case R.id.page_chat:
                    replaceFragment(FragmentType.CHAT);
                    break;
                case R.id.page_my_info:
                    replaceFragment(FragmentType.MY_INFO);
                    break;
            }
            return true;
        });
    }
}