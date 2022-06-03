package com.example.movie_1.adapter;

// 내부 클래스 먼저 만들기

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_1.R;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemClicked onMovieItemClicked;

    public void setOnMovieItemClicked(OnMovieItemClicked onMovieItemClicked) {
        this.onMovieItemClicked = onMovieItemClicked;
    }
    // 통신 배우기전 생성자에 데이터를 전달 받아서 화면을 구성
    // 통신이기 때문에 화면을 그리는 시점보다 더 늦게 데이터가 도달 할 수 있다.

    public void initItemList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem(List<Movie> addList) {
        // list.size() --> 0
        // list.size() --> 10
        // list.size() --> 20
        // list.size() --> 30
        this.list.addAll(list.size(), addList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movie movie = list.get(position);
//        // 1. 여기서 바로 세팅하기
//        holder.titleTv.setText(movie.getTitle());
//        holder.ratingTv.setText(String.valueOf(movie.getRating()));
//        // 9.312 () --> Math.floor()
//        holder.ratingBar.setRating((float) movie.getRating());
//
//        Glide.with(holder.posterIv.getContext())
//                .load(movie.getMediumCoverImage())
//                .placeholder(R.drawable.round_image)
//                .transform(new FitCenter(), new RoundedCorners(20))
//                .into(holder.posterIv);

        // 2. view holder 안에서 세팅
        // 메서드 (movie)
        holder.setItem(movie);
        holder.itemView.setOnClickListener(view -> {
            onMovieItemClicked.selectedItem(movie);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner static class
    // view binding 뷰결합 안됨(리사이클러뷰), 직접해야함 -> 단방향
    // data binding 뷰결합 -> 양방향
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // itemView 에 선언한 데이터 타입들 선언하고 생성 시점에 R.id.xxx 연결해주면 된다.
        private View itemView;
        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie) {
            titleTv.setText(movie.getTitle());
            ratingTv.setText(String.valueOf(movie.getRating()));
            // 9.312 () --> Math.floor()
            ratingBar.setRating((float) movie.getRating());

            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterIv);

            itemView.setOnClickListener(view -> {
                Log.d("TAG", "" + view.getContext());
            });
        }
    }
}
