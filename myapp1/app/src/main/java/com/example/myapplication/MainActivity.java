package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView plus;
    private TextView subtract;
    private TextView multiply;
    private TextView divide;
    private TextView equal;
    private TextView ca;
    private TextView result;

    String newValue = "0";
    String oldValue = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator2);
        initData();
        addEventListener();
    }

    private void initData(){
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        ca = findViewById(R.id.ca);
        result = findViewById(R.id.result);
        System.out.println("initData 메서드 호출");
    }

    private void addEventListener(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newValue = newValue + "1";
                result.setText(newValue);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newValue = newValue + "2";
                result.setText(newValue);
            }
        });

        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(newValue);
        });

        four.setOnClickListener(view -> {
            newValue = newValue + "4";
            result.setText(newValue);
        });

        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(newValue);
        });

        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(newValue);
        });

        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(newValue);
        });

        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(newValue);
        });

        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(newValue);
        });

        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(newValue);
        });

        plus.setOnClickListener(view -> {
            // 1  (newValue = 1)
            // 2  +
            int number1 = Integer.parseInt(newValue);
            int number2 = Integer.parseInt(oldValue);
            int sum = (number1 + number2);
            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
        });

        subtract.setOnClickListener(view -> {
            

        });

        multiply.setOnClickListener(view -> {

        });

        divide.setOnClickListener(view -> {

        });

        equal.setOnClickListener(view -> {

        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            result.setText("0");
        });


    }


}