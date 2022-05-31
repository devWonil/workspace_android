package com.example.myretrofit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myretrofit3.models.request.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;
import com.example.myretrofit3.service.JPHService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private JPHService service;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();
    }

    private void initData() {

        service = JPHService.retrofit.create(JPHService.class);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }

    private void addEventListener() {
        btn1.setOnClickListener(view -> {
            service.post(2).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if (response.isSuccessful()){
                        // 자동 파싱 json -> object 변환처리
                        ResponsePostDto dto = response.body();
                        Log.d(TAG, dto + "");
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {

                }
            });
        });

        btn2.setOnClickListener(view -> {
            service.postList().enqueue(new Callback<List<ResponsePostDto>>() {
                @Override
                public void onResponse(Call<List<ResponsePostDto>> call, Response<List<ResponsePostDto>> response) {
                    Log.d(TAG, response.code() + "<-- code");
                    ArrayList<ResponsePostDto> list = (ArrayList<ResponsePostDto>) response.body();
                    Log.d(TAG, list.toString());
                }

                @Override
                public void onFailure(Call<List<ResponsePostDto>> call, Throwable t) {

                }
            });
        });

        btn3.setOnClickListener(view -> {
            // 로그인 (userId --> sharedPreference에 저장) (SQLite) (메모리 변수 저장)
            ReqPostDto reqPostDto = new ReqPostDto("회의", "db 설계", 10);
            service.createPost(reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, response.body().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    Log.d(TAG, t.toString());
                }
            });
        });

        btn4.setOnClickListener(view -> {
            ReqPostDto reqPostDto = new ReqPostDto("회의", "db 설계", 10);
            service.updatePost(reqPostDto).enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if (response.isSuccessful()) {

                        Toast.makeText(MainActivity.this, "업데이트 성공", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, response.body().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "업데이트 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    Log.d(TAG, t.toString());
                }
            });
        });

        btn5.setOnClickListener(view -> {
            service.deletePost(1).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "삭제 성공", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, response.body().toString());
                    }else {
                        //Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    //Log.d(TAG, t.toString());
                }
            });
        });

        btn6.setOnClickListener(view -> {
            Log.d("TAG", "btn6 click");
        });
    }

}