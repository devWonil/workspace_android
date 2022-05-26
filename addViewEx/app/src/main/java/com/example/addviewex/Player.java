package com.example.addviewex;

import java.util.ArrayList;

public class Player {

    String imageUrl;
    String playerName;
    String playerPosition;
    String playerNationality;
    String playerClub;
    String playerMarketValue;

    public Player(String imageUrl, String playerName, String playerPosition, String playerNationality, String playerClub, String playerMarketValue){
        this.imageUrl = imageUrl;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerNationality = playerNationality;
        this.playerClub = playerClub;
        this.playerMarketValue = playerMarketValue;
    }

    public static ArrayList<Player> getPlayers() {
        ArrayList<Player> list = new ArrayList<>();
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward      23", "France", "Paris Saint-Germain", "€ 160m"));
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/418560-1632685669.jpg?lm=1", "Erling Haaland", "Centre-Forward      21", "Norway", "Manchester City", "€ 150m"));
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/371998-1653042643.jpg?lm=1", "Vinicius Junior", "Left Winger      21", "Brazil", "Real Madrid", "€ 100m"));
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/148455-1546611604.jpg?lm=1", "Mohamed Salah", "Right Winger      29", "Egypt", "Liverpool FC", "€ 100m"));
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/132098-1623778520.jpg?lm=1", "Harry Kane", "Centre-Forward      28", "England", "Tottenham Hotspur", "€ 100m"));
        list.add(new Player("https://img.a.transfermarkt.technology/portrait/big/406635-1594986905.jpg?lm=1", "Phil Foden", "Central Midfield      21", "England", "Manchester City", "€ 90m"));

        return list;
    }
}
