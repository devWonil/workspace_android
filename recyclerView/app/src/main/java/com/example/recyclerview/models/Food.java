package com.example.recyclerview.models;

import java.io.Serializable;
import java.util.ArrayList;

// 직렬화 : OBJECT -> Byte
// 역직렬화 : byte -> OBJECT
public class Food implements Serializable {

    private String thumbnail;
    private String title;
    private String subTitle;
    private String detail;

    public Food(String thumbnail, String title, String subTitle, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ArrayList<Food> getSampleData() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food1", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food2", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food3", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food4", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food5", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food6", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food7", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food8", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food9", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food10", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food11", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food12", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food13", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food14", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food15", "SubTitle1", "detail"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__340.jpg", "Food16", "SubTitle1", "detail"));
        return foods;
    }
}
