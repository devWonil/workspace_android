package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        Button button = findViewById(R.id.btnFinish);
        int value1 = getIntent().getIntExtra("value1", 0);
        Log.d("TAG", "value1 : " + value1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 값을 mainActivity에 보내기
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", value1 + 10);
                // 반드시 기억하기
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}