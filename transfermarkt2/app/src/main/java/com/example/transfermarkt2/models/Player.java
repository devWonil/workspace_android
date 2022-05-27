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
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/342229-1632686046.jpg?lm=1", "Kylian Mbappe", "Centre-Forward\n23\nFrance\nParis Saint-Germain\n€ 160m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/418560-1632685669.jpg?lm=1", "Erling Haaland", "Centre-Forward\n21\nNorway\nManchester City\n€ 150m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/371998-1653042643.jpg?lm=1", "Vinicius Junior", "Left Winger\n21\nBrazil\nReal Madrid\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/148455-1546611604.jpg?lm=1", "Mohamed Salah", "Right Winger\n29\nEgypt\nLiverpool FC\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/132098-1623778520.jpg?lm=1", "Harry Kane", "Centre-Forward\n28\nEngland\nTottenham Hotspur\n€ 100m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/406635-1594986905.jpg?lm=1", "Phil Foden", "Central Midfield\n21\nEngland\nManchester City\n€ 90m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/240306-1636537174.jpg?lm=1", "Bruno Fernandes", "Attacking Midfield\n27\nPortugal\nManchester United\n€ 90m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/88755-1626449012.jpg?lm=1", "Kevin De Bruyne", "Attacking Midfield\n30\nBelgium\nManchester City\n€ 90m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/68290-1632687616.jpg?lm=1", "Neymar", "Left Winger\n30\nBrazil\nParis Saint-Germain\n€ 90m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/357498-1632225570.jpg?lm=1", "Dušan Vlahović", "Centre-Forward\n22\nSerbia\nJuventus FC\n€ 85m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/161056-1636537308.jpg?lm=1", "Joshua Kimmich", "Defensive Midfield\n27\nGemany\nBayern Munich\n€ 85m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/134425-1577051521.jpg?lm=1", "Raheem Sterling", "Left Winger\n27\nEngland\nManchester City\n€ 85m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/96341-1596033546.jpg?lm=1", "Romelu Lukaku", "Centre-Forward\n29\nBelgium\nChelsea FC\n€ 85m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/683840-1620304992.jpg?lm=1", "Pedri", "Central Midfield\n19\nSpain\nFC Barcelona\n€ 80m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/401173-1632686361.jpg?lm=1", "Jadon Sancho", "Left Winger\n22\nEngland\nManchester United\n€ 80m", "Click to see details"));
        players.add(new Player("https://img.a.transfermarkt.technology/portrait/big/314353-1559826986.jpg?lm=1", "Trent Alexander-Arnold", "Right-Back\n23\nEngland\nLiverpool FC\n€ 80m", "Click to see details"));
        return players;
    }
}
