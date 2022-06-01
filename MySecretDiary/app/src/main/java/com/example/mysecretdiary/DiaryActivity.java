package com.example.mysecretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        // 사용자가 이전에 적었던 비밀 데스노트(일기장) 불러와야한다.
        SharedPreferences notePreference = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreference.getString("detail", ""));

        // 스레드 기능 구현
        Runnable runnable = () -> {
            SharedPreferences preference = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preference.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };
        // 사용자가 한글자 한글자 입력할 때마다 이벤트리스너를 등록해서 변경사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TAG", "char : " + charSequence);
                Log.d("TAG", "i : " + i);
                Log.d("TAG", "i1 : " + i1);
                Log.d("TAG", "i2 : " + i2);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 한글자 한글자 입력이 들어 올 때 마다 SharedPreference에 저장
                // 여기에서 다른 스레드한테 일 해달라고 요청함
                handler.removeCallbacks(runnable); // 이전 연산 삭제
//                handler.post(runnable);
                handler.postDelayed(runnable, 500);
                // 위 코드를 새로운 스레드를 만들어서 비동기 저장
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TAG", "s : " + s);
            }
        });
    }

}