package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count){
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    // 샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__480.jpg", "수박", "100000", "1"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2015/12/09/17/11/vegetables-1085063__340.jpg", "딸기", "110000", "2"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "사과", "120000", "3"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/11/04/19/05/christmas-2918569__340.jpg", "체리", "130000", "4"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/06/02/18/24/watermelon-2367029__340.jpg", "포도", "140000", "5"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/05/13/17/31/fruit-2310212__340.jpg", "배", "150000", "6"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/07/22/09/59/fruits-1534494__340.jpg", "복숭아", "160000", "7    "));

        return list;
    }
}
