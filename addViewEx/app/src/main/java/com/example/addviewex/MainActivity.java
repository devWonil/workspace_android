package com.example.addviewex;

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

        ArrayList<Player> sampleData = Player.getPlayers();

        LinearLayout container = findViewById(R.id.playerContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        sampleData.forEach(player -> {
            View playerView = inflater.inflate(R.layout.football_player, container, false);

            ImageView playerImageView = playerView.findViewById(R.id.playerImageView);
            TextView playerName = playerView.findViewById(R.id.playerName);
            TextView playerPosition = playerView.findViewById(R.id.playerPosition);
            TextView playerNationality = playerView.findViewById(R.id.playerNationality);
            TextView playerClub = playerView.findViewById(R.id.playerClub);
            TextView playerMarketValue = playerView.findViewById(R.id.playerMarkerValue);

            playerName.setText(player.playerName);
            playerPosition.setText(player.playerPosition);
            playerNationality.setText(player.playerNationality);
            playerClub.setText(player.playerClub);
            playerMarketValue.setText(player.playerMarketValue);

            Glide.with(this)
                    .load(player.imageUrl)
                    .centerCrop()
                    .into(playerImageView);

            container.addView(playerView);
        });
    }
}