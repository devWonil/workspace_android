package com.example.myaddview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fruit> sampleData = Fruit.getFruits();

        // addView 방식으로 쓸 때는 뷰를 위치시킬 컨테이너 가져오기
        LinearLayout container = findViewById(R.id.fruitContainer);
        LayoutInflater inflater = LayoutInflater.from(this); // new LayoutInflater(); 와 같다
        // inflater 객체를 이용해서 xml 파일을 메모리에 올리고 설정!!

        sampleData.forEach(fruit -> {
            View itemView = inflater.inflate(R.layout.item_food, container, false);

            ImageView fruitImageView = itemView.findViewById(R.id.fruitImageView);
            TextView fruitNameTextView = itemView.findViewById(R.id.fruitNameTextView);
            TextView fruitPrice = itemView.findViewById(R.id.fruitPrice);
            TextView fruitCount = itemView.findViewById(R.id.fruitCount);
            fruitNameTextView.setText(fruit.name);
            fruitPrice.setText(fruit.price);
            fruitCount.setText(fruit.count);

            // 이미지 세팅
            Glide.with(this)
                    .load(fruit.imageUrl)
                    .centerCrop()
                    .into(fruitImageView);

            container.addView(itemView);
        });
    }
}