package com.example.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myfragment.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity3 extends AppCompatActivity {

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
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(type == FragmentType.HOME){
            fragment = new FragmentHome();
        } else if (type == FragmentType.COPY){
            fragment = new FragmentCopy();
        } else if (type == FragmentType.LOCATION){
            fragment = new FragmentLocation();
        } else if (type == FragmentType.CHATTING){
            fragment = new FragmentChatting();
        } else{
            fragment = new FragmentMyInfo();
        }

        transaction.replace(R.id.bottomNavigation, fragment);
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menuItem1:
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.menuItem2:
                    replaceFragment(FragmentType.COPY);
                    break;
                case R.id.menuItem3:
                    replaceFragment(FragmentType.LOCATION);
                    break;
                case R.id.menuItem4:
                    replaceFragment(FragmentType.CHATTING);
                    break;
                case R.id.menuItem5:
                    replaceFragment(FragmentType.MYINFO);
                    break;
            }
            return true;
        });
    }

}