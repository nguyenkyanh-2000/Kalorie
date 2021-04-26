package com.example.kalorie.ui.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kalorie.data.model.Post;
import com.example.kalorie.data.network.APIService;
import com.example.kalorie.data.network.RetroInstance;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<Post>> postList;

    public PostListViewModel(){
        postList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Post>> getMoviesListObserver() {
        return postList;

    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<Post>> call = apiService.getPostList();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postList.postValue(null);
            }
        });
    }
}