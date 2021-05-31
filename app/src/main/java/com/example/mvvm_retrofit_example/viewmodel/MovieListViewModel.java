package com.example.mvvm_retrofit_example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_retrofit_example.model.MovieModel;
import com.example.mvvm_retrofit_example.network.APIService;
import com.example.mvvm_retrofit_example.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<List<MovieModel>> mutableLiveData;

    public MovieListViewModel(){
        mutableLiveData=new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMoviesListObserver(){
        return mutableLiveData;
    }

    public void makeApiCall(){
        APIService apiService= new RetrofitInstance().getRetrofitInstance().create(APIService.class);
        Call<List<MovieModel>> call=apiService.getMoviesList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                mutableLiveData.postValue(null);

            }
        });

    }
}
