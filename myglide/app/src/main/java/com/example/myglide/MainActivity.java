package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        Glide.with(this).load(R.drawable.screenshot_4).circleCrop().into(imageView1);
        Glide.with(this).load(R.drawable.screenshot_5).circleCrop().into(imageView2);
        Glide.with(this).load(R.drawable.screenshot_6).circleCrop().into(imageView3);
        Glide.with(this).load(R.drawable.screenshot_7).circleCrop().into(imageView4);
        Glide.with(this).load(R.drawable.screenshot_8).circleCrop().into(imageView5);
        Glide.with(this).load(R.drawable.screenshot_9).circleCrop().into(imageView6);

//        Glide.with(this)
//                .load("https://picsum.photos/200/300/?blur")
//                .circleCrop()
//                .into(imageView1);

        // 프로젝트에 있는 이미지들을 라운드 처리하는 라이브러리를 사용해서
        // circleCrop 처리 한다면 사용안 됨

        // 6개 이미지에 (인물 사진) 그리기
    }
}