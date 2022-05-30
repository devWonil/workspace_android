package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(() -> {
            initData();
            httpGetTest();
        }).start();
//        try {
//            httpGetTest();
//        } catch (NetworkOnMainThreadException e) {
//            Toast.makeText(this, "에러가 발생", Toast.LENGTH_SHORT).show();
//        }

    }

    private void initData() {
        btn = findViewById(R.id.button);
        textView = findViewById(R.id.text);
    }

    private void addEventListener() {

    }

    private void httpGetTest() {
        // https://jsonplaceholder.typicode.com/todos/1
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 참고
            // connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                // 통신 성공
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                ));
                // 1. 한 라인
                // reader.ready();
//                String line = null;
//                StringBuffer sb = new StringBuffer();
//
//                while((line = reader.readLine()) != null){
//                    sb.append(line + "\n");
//                }
//                Log.d("TAG", sb.toString());

                // Dto 생성

                // 문자열 -> 하나의 object로 변환하는 방법
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG", todo1.title);

                // 문자열 -> 배열타입으로 변환
//                Todo[] todos = new Gson().fromJson(reader, Todo[].class);

//                Log.d("TAG", todos.toString());
                // 문자열 -> ArrayList 타입으로 변환
                // 1.
                Type todoListType = new TypeToken<ArrayList<Todo>>() {}.getType();
                // 2.
                ArrayList<Todo> todoList = new Gson().fromJson(reader, todoListType);

//                for (Todo t: todoList) {
//                    Log.d("TAG", t.userId + " userId");
//                    Log.d("TAG", t.id + " id");
//                    Log.d("TAG", t.title + " title");
//                    Log.d("TAG", t.body + " body");
//                }
                //Todo t = new Todo();
                btn.setOnClickListener(view -> {
                    SharedPreferences preferences = getSharedPreferences("sp1", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    for(Todo t: todoList){
                        editor.putInt("userId", t.userId);
                        editor.putInt("id", t.id);
                        editor.putString("title", t.title);
                        editor.putString("body", t.body);
                        editor.apply();

                        Log.d("TAG", "userId : " + t.userId);
                        Log.d("TAG", "id : " + t.id);
                        Log.d("TAG", "title : " + t.title);
                        Log.d("TAG", "body : " + t.body);
                    }


                });


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}