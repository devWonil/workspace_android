package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    boolean flag = true;
    private String arithmeticSymbol = "";

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

    private void takeAwayZero(String num){
        int nv = Integer.parseInt(newValue);
        if (nv == 0){
            newValue = num;
        }else {
            newValue = newValue + num;
        }
        result.setText(newValue);
    }

    private void addEventListener(){
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeAwayZero("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeAwayZero("2");
            }
        });

        three.setOnClickListener(view -> {
            takeAwayZero("3");
        });

        four.setOnClickListener(view -> {
            takeAwayZero("4");
        });

        five.setOnClickListener(view -> {
            takeAwayZero("5");
        });

        six.setOnClickListener(view -> {
            takeAwayZero("6");
        });

        seven.setOnClickListener(view -> {
            takeAwayZero("7");
        });

        eight.setOnClickListener(view -> {
            takeAwayZero("8");
        });

        nine.setOnClickListener(view -> {
            takeAwayZero("9");
        });

        zero.setOnClickListener(view -> {
            takeAwayZero("0");
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
            newValue = "0"; // 초기화
            result.setText(oldValue);
            arithmeticSymbol = "+";
//            newValue = newValue + "+";
//            result.setText(newValue);
        });

        subtract.setOnClickListener(view -> {
            int number1 = Integer.parseInt(newValue);
            int number2 = Integer.parseInt(oldValue);
            int sum = (number2 - number1);
            if(flag){
                sum = (-sum);
                flag =! flag;
            }
            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
            arithmeticSymbol = "-";
//            newValue = newValue + "-";
//            result.setText(newValue);
        });

        multiply.setOnClickListener(view -> {
            int number1 = Integer.parseInt(newValue);
            int number2 = Integer.parseInt(oldValue);
            if(flag){
                number2 = 1;
                flag =! flag;
            }
            int sum = (number2 * number1);

            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);
            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);
            arithmeticSymbol = "*";
        });

        divide.setOnClickListener(view -> {
            int number1 = Integer.parseInt(newValue);
            double number2 = Integer.parseInt(oldValue);
            if(flag){
                int sum = number1;
                Log.d(TAG, "number1 : " + number1);
                Log.d(TAG, "number2 : " + number2);
                Log.d(TAG, "sum : " + sum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
                flag =! flag;
            }else{
                if(number1 == 0){
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                }else{
                    double sum = (number2 / number1);
                    Log.d(TAG, "number1 : " + number1);
                    Log.d(TAG, "number2 : " + number2);
                    Log.d(TAG, "sum : " + sum);
                    oldValue = String.valueOf(sum);
                    newValue = "0";
                    result.setText(oldValue);
                }
            }
            arithmeticSymbol = "/";
        });

        equal.setOnClickListener(view -> {
            if(arithmeticSymbol.equals("+")){
                int number1 = Integer.parseInt(newValue);
                int number2 = Integer.parseInt(oldValue);
                int sum = (number1 + number2);
                Log.d(TAG, "number1 : " + number1);
                Log.d(TAG, "number2 : " + number2);
                Log.d(TAG, "sum : " + sum);
                oldValue = String.valueOf(sum);
                newValue = "0"; // 초기화
                result.setText(oldValue);
            } else if(arithmeticSymbol.equals("-")){
                int number1 = Integer.parseInt(newValue);
                int number2 = Integer.parseInt(oldValue);
                int sum = (number2 - number1);
                if(flag){
                    sum = (-sum);
                    flag =! flag;
                }
                Log.d(TAG, "number1 : " + number1);
                Log.d(TAG, "number2 : " + number2);
                Log.d(TAG, "sum : " + sum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
            } else if(arithmeticSymbol.equals("*")){
                int number1 = Integer.parseInt(newValue);
                int number2 = Integer.parseInt(oldValue);
                if(flag){
                    number2 = 1;
                    flag =! flag;
                }
                int sum = (number2 * number1);

                Log.d(TAG, "number1 : " + number1);
                Log.d(TAG, "number2 : " + number2);
                Log.d(TAG, "sum : " + sum);
                oldValue = String.valueOf(sum);
                newValue = "0";
                result.setText(oldValue);
            } else if(arithmeticSymbol.equals("/")){
                int number1 = Integer.parseInt(newValue);
                double number2 = Integer.parseInt(oldValue);
                if(flag){
                    int sum = number1;
                    Log.d(TAG, "number1 : " + number1);
                    Log.d(TAG, "number2 : " + number2);
                    Log.d(TAG, "sum : " + sum);
                    oldValue = String.valueOf(sum);
                    newValue = "0";
                    result.setText(oldValue);
                    flag =! flag;
                }else{
                    if(number1 == 0){
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    }else{
                        double sum = (number2 / number1);
                        Log.d(TAG, "number1 : " + number1);
                        Log.d(TAG, "number2 : " + number2);
                        Log.d(TAG, "sum : " + sum);
                        oldValue = String.valueOf(sum);
                        newValue = "0";
                        result.setText(oldValue);
                    }
                }
            }
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            result.setText("0");
            flag = !flag;
        });


    }


}