package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private FragmentBanner fragmentBanner;
    private Button btnCreate;
    private Button btnDelete;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCreate = findViewById(R.id.btnCreate);
        btnDelete = findViewById(R.id.btnDelete);
        container = findViewById(R.id.container);

        btnCreate.setOnClickListener(view -> {

            fragmentBanner = new FragmentBanner();

            // 프래그먼트를 동적으로 만들기 위해서 필요한 준비물
            // 1. FragmentManager (프래그먼트 트랜잭션 객체를 가져올 수 있다)
            // 2. FragmentTransaction () transaction (작업의 단위 - 시작과 끝이 있다)
            // 여러개 부분 부분 작업들을 한 단위로 만들어준다.

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // 지금부터 transaction 처리를 할 거야

            // 실행 코드 xml 파일 만들어 둔 영역(view component에 올려라)
            transaction.replace(R.id.container, fragmentBanner);

            transaction.commit(); // 시간될 때 완료해 (시스템에 요청)
            // transaction.commitNow(); // 지금 당장해 (시스템에 요청)
            // transaction.commitAllowingStateLoss(); // 위험 (커밋이 없어질 수 있다)
        });

        // 프래그먼트 제거
        btnDelete.setOnClickListener(view -> {
            // remove
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentBanner);
            //transaction.detach(fragmentBanner);
            transaction.commit();

        });
    }
}