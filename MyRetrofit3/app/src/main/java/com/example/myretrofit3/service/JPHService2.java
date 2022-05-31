package com.example.myretrofit3.service;

import com.example.myretrofit3.models.request.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JPHService2 {

    // 레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // https://jsonplaceholder.typicode.com/posts/{id}
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

    // https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    // https://jsonplaceholder.typicode.com/posts/{postId}
    // HTTP 메시지 body 부분에 데이터를 넣어서 서버에 전달한다.(MIME TYPE : Json)
    // 값을 보낼 때 어떻게 데이터를 보낼지 설계해야한다
    @POST("posts/{postId}")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Body ReqPostDto reqPostDto);

    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

    @FormUrlEncoded
    @GET("/posts")
    Call<List <ResponsePostDto>> searchByUserId(@Field("userId") int userId);
}
