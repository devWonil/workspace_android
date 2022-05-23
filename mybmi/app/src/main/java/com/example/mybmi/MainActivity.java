package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout heightEt;
    TextInputLayout weightEt;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(view -> {
            Editable weightEditable = weightEt.getEditText().getText();
            Editable heightEditable = heightEt.getEditText().getText();

            if(weightEditable.length() < 1 || heightEditable.length() < 1){
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_LONG).show();
                return;
            }
            try {
                int height = Integer.parseInt(heightEditable.toString());
                int weight = Integer.parseInt(weightEditable.toString());
                Log.d("TAG","height : " + height);
                Log.d("TAG","weight : " + weight);

                Intent intent = new Intent(this, BmiResultActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);

            }catch (NumberFormatException e){
                Toast.makeText(this, "잘 못 입력했습니다", Toast.LENGTH_LONG).show();
            }

        });
    }
}