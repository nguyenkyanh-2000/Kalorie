package com.example.kalorie.data.network;

import com.example.kalorie.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("volley_array.json")
    Call<List<Post>> getPostList();
}