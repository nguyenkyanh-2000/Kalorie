package com.example.kalorie.data.network;

import com.example.kalorie.data.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("volley_array.json")
    Call<List<Food>> getFoodList();
}