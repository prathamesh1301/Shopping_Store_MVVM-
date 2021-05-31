package com.example.mvvm_retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_retrofit_example.adapter.MovieListAdapter;
import com.example.mvvm_retrofit_example.model.MovieModel;
import com.example.mvvm_retrofit_example.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.ItemClickListener{
    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        movieModelList=new ArrayList<>();
        adapter=new MovieListAdapter(this,movieModelList,this);
        recyclerView.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels!=null){
                    movieModelList=movieModels;
                    adapter.setMovieList(movieModels);
                }else{
                    Toast.makeText(MainActivity.this, "No result found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.makeApiCall();


    }

    @Override
    public void onMovieClick(MovieModel m) {
        Toast.makeText(this, m.getTitle(), Toast.LENGTH_SHORT).show();
    }
}