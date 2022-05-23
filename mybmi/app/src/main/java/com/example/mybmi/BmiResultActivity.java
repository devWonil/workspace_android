package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        if(getIntent() != null){
            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            // 체중 / 신장(m) ^2
            double bmiValue = weight / Math.pow(height / 100.0, 2);
            Log.d("TAG", bmiValue + " ");
            String resultText = "";
            if(bmiValue < 18.5){
                resultText = "저체중입니다.";
            }else if(bmiValue <23){
                resultText = "정상체중입니다.";
            }else if(bmiValue <24.9){
                resultText = "과체중입니다.";
            }else if(bmiValue <29.9){
                resultText = "비만입니다";
            }else{
                resultText = "고도비만입니다";
            }
            //String getData = getIntent().getStringExtra(String.valueOf(bmiValue));
            textView1.setText(String.valueOf(bmiValue));
            textView2.setText(resultText);
        }

    }
}