package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

        // sharedPreference
        SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
        // Mode
        // - MODE_PRIVATE : 생성한 어플리케이션에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 앱에서 사용 가능하지만 읽을 수만 있다.
        // - MODE_WORLD_WRITABLE : 다른 앱에서 사용가능하고 기록도 가능

        // 데이터를 입력해보기
        // 데이터를 넣기 위해 수정모드로 먼저 만들어야한다.
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("name", "홍길동");
        // 저장 안됨

        //editor.apply();

        // apply() 와 commit()의 차이점
        // apply()는 스레드를 블록시키지 않는다. (비동기 방식, 저장 성공여부 true, false 값을 주지 않음)
        // commit()은 스레드가 블록된다. (동기 방식, 저장 성공시 true 값 반환)


        editor.apply(); // 저장 완료
    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }

    private void addEventListener() {

        btnSave.setOnClickListener(view -> {
            // 1. sharedPreference 객체를 불러온다 (이름, 모드)
            // 2. 수정모드로 만들어 줘야한다.
            // 3. 저장할 데이터를 입력한다.
            // 4. 비동기 방식으로 데이터를 완전히 저장한다
            // name(String), age(int), isMarried(Boolean) 데이터를 저장하는 기능을 만들어주세요

            SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", "이순신");
            editor.putInt("age", 23);
            editor.putBoolean("isMarried", true);
            editor.apply();

        });

        btnLoad.setOnClickListener(view -> {
            SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE);
            // 데이터 읽어보기
            String name = preferences.getString("name", "");
            int age = preferences.getInt("age", 0);
            boolean isMarried = preferences.getBoolean("isMarried", false);
            Toast.makeText(this, "age : " + age, Toast.LENGTH_LONG).show();
            Log.d("TAG", "name 값 확인 : " + name);
            Log.d("TAG", "age 값 확인 : " + age);
            Log.d("TAG", "isMarried 값 확인 : " + isMarried);

        });

        btnDelete.setOnClickListener(view -> {
            // 메소드 체이닝 방식으로 코드 작성하기
            // age만 삭제
            getShared("sp1").edit().remove("age").apply();
            getShared("sp1").edit().remove("isMarried").apply();
            // 잘 삭제가 되었는지 확인하기

            // 코드상으로 버튼을 눌렀다 명령하기
            btnLoad.callOnClick();
        });

        btnDeleteAll.setOnClickListener(view -> {
            getShared("sp1").edit().clear().apply();

            // 코드상으로 버튼 누르기
            btnLoad.callOnClick();

        });
    }

    private SharedPreferences getShared(String name){
        return getSharedPreferences(name, MODE_PRIVATE);
    }
}