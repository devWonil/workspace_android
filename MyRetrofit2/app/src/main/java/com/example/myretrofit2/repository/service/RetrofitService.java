package com.example.myretrofit2.repository.service;

import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    //https://jsonplaceholder.typicode.com/todos
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    //https://jsonplaceholder.typicode.com/todos/100
    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") int id);

    //https://jsonplaceholder.typicode.com/posts
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
        @Field("userId") int userId,
        @Field("id") int id,
        @Field("title") String title,
        @Field("body") String body
    );
}
