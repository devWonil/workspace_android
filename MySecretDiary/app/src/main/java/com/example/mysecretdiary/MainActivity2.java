package com.example.mysecretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button openButton;
    private Button changePasswordButton;
    private SharedPreferences passwordPreference;

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    // 프로그램 흐름 (두가지 모드)
    private boolean changePasswordMode = false;
    private final static String KEY_PWD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);

        numberPicker1.setMaxValue(9);
        numberPicker1.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker3.setMinValue(0);

        openButton = findViewById(R.id.openButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
        passwordPreference = getSharedPreferences(KEY_PWD, Context.MODE_PRIVATE);
    }

    private void addEventListener() {
        // 비밀 다이어리 오픈 버튼 눌렀을 때 동작 처리
        openButton.setOnClickListener(view -> {
            if (changePasswordMode) {
                // 작은 버튼 눌러서 색상 변경되었을 때 진행을 시키면 안됨
                Toast.makeText(this, "비밀번호 변경중...", Toast.LENGTH_SHORT).show();
                return;
            }

            // 저장되어있는 패스워드 데이터를 불러와서 확인해야한다
            String passwordFromUser = getUserNumber();

            // 비밀번호 세팅하지 않았을 경우 초기값 세팅으로 처리
            if (passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)){
                // 패스워드 확인 성공
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            } else {
                // 사용자에게 비밀번호 틀렸다 알려준다
                showErrorAlertDialog();
            }
        });

        // 비밀번호 변경 버튼 눌럿을 경우 동작 처리
        changePasswordButton.setOnClickListener(view -> {
            String passwordFromUser = getUserNumber();

            // 비밀번호 변경중이면
            if (changePasswordMode) {
                //저장처리
                SharedPreferences.Editor editor = passwordPreference.edit();
                editor.putString(KEY_PWD, getUserNumber());
                editor.apply(); //비동기방식

                changePasswordMode = false;
                changePasswordButton.setBackgroundColor(Color.BLACK);

            } else { // 처음 변경하겠다고 누르는 경우
                // 비밀번호 변경모드 활성화시키기
                // 단, 현재 넘버피커 숫자가 내가 정한 비밀번호와 일치해야 변경가능
                if (passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)){
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력하세요", Toast.LENGTH_SHORT).show();
                    changePasswordButton.setBackgroundColor(Color.RED);
                }else {
                    showErrorAlertDialog();
                }

            }
        });
    }

    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다")
                .setPositiveButton("닫기", (dialogInterface, i) -> {
                    Log.d("TAG", "1111111111");
                });
        builder.show();
    }

    private String getUserNumber() {
        String passwordFromUser = "" + numberPicker1.getValue() +
                numberPicker2.getValue() + numberPicker3.getValue();
        return passwordFromUser;
    }
}