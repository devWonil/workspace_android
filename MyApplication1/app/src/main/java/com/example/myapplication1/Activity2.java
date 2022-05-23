package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView1 = findViewById(R.id.nameTextView);
//        textView2 = findViewById(R.id.textView2);
//        textView3 = findViewById(R.id.textView3);

        // 값을 받는 방법
        // 값이 없다면 기본값을 0으로 셋팅
        // 방어적 코드
        if(getIntent() != null){
            String getData = getIntent().getStringExtra(Activity1.KEY_NAME);
            textView1.setText(getData);
        }
        // 값을 전달받아서 화면에 뿌리기
    }
}