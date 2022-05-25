package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavi.utils.FragmentCal;
import com.example.bottomnavi.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        addBottomNavigationListener();
        replaceFragment(FragmentType.HOME);
    }

    private void replaceFragment(FragmentType type){
        // 플래그먼트 3 개 생성
        // 플래그먼트 매니저
        // 플래그먼트 트랜잭션
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(type == FragmentType.HOME){
            fragment = new FragmenHome();
        }else if(type == FragmentType.TV){
            fragment = new FragmentTv();
        }else{
            fragment = new FragmentCal();
        }
        // 지금부터 transaction 처리를 할 거야
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
        // 실행 코드 xml 파일 만들어 둔 영역(view component에 올려라)
         // 시간될 때 완료해 (시스템에 요청)
    }

    private void addBottomNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_chat:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.TV);
                    break;
                case R.id.page_my_info:
                    // 플래그먼트 교체
                    replaceFragment(FragmentType.CAL);
                    break;
            }
            return true;
        });
    }
}