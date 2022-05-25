package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);

        // 프래그먼트 생성
        btnCreate.setOnClickListener(View -> {

            fragmentBanner = new FragmentBanner();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragmentBanner);
            transaction.commit();
        });

        // 프래그먼트 제거
        btnDelete.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner);
            transaction.commit();
        });
    }
}