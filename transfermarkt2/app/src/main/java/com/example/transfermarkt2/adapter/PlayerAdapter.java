package com.example.transfermarkt2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.transfermarkt2.R;
import com.example.transfermarkt2.models.Player;

import java.util.ArrayList;

// 뷰 홀더 만들기
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {

    // 멤버 변수
    ArrayList<Player> list;
    Context context;

    public PlayerAdapter(ArrayList<Player> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View playerView = LayoutInflater.from(context).inflate(R.layout.player, parent, false);

        return new MyViewHolder(playerView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.MyViewHolder holder, int position) {

        Log.d("TAG", "position : " + position);
        Player player = list.get(position);
        Glide.with(context)
                .load(player.getThumbnail())
                .centerCrop()
                .into(holder.thumbnail);

        holder.nameTextView.setText(player.getName());
        holder.infoTextView.setText(player.getInfo());
        holder.detailTextView.setText(player.getDetail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView nameTextView;
        TextView infoTextView;
        TextView detailTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);

            itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), getLayoutPosition() +1+"위", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
