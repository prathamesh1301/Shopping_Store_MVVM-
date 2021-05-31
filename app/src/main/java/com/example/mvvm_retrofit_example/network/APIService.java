package com.example.mvvm_retrofit_example.network;

import com.example.mvvm_retrofit_example.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("products")
    Call<List<MovieModel>> getMoviesList();
}
