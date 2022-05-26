package com.example.transfermarkt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.transfermarkt2.adapter.PlayerAdapter;
import com.example.transfermarkt2.models.Player;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Player> playersList = Player.getPlayersData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new PlayerAdapter(Player.getPlayersData(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}