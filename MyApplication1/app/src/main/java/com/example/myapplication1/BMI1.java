package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BMI1 extends AppCompatActivity {

    private EditText textView1;
    private EditText textView2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi1);
        initData();
        addEventListener();
    }

    private void initData(){
        //textView1 = findViewById(R.id.);
    }

    private void addEventListener(){

    }
}