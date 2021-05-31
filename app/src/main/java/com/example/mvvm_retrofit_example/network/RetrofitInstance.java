package com.example.mvvm_retrofit_example.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL="https://fakestoreapi.com/";
    public Retrofit retrofit=null;
    public Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
