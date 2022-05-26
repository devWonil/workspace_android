package com.example.transfermarkt2.models;

import java.util.ArrayList;

public class Player {

    private String thumbnail;
    private String name;
    private String info;
    private String detail;

    public Player(String thumbnail, String name, String info, String detail) {
        this.thumbnail = thumbnail;
        this.name = name;
        this.info = info;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ArrayList<Player> getPlayersData(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/418560-1632685669.jpg?lm=1", "Erling Haaland", "Centre-Forward\t21\nNorway\nManchester City\n€ 150m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/371998-1653042643.jpg?lm=1", "Vinicius Junior", "Left Winger\t21\nBrazil\nReal Madrid\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/148455-1546611604.jpg?lm=1", "Mohamed Salah", "Right Winger\t29\nEgypt\nLiverpool FC\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/132098-1623778520.jpg?lm=1", "Harry Kane", "Centre-Forward\t28\nEngland\nTottenham Hotspur\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/406635-1594986905.jpg?lm=1", "Phil Foden", "Central Midfield\t21\nEngland\nManchester City\n€ 90m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\t23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        return players;
    }
}
