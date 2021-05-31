package com.example.mvvm_retrofit_example.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_retrofit_example.R;
import com.example.mvvm_retrofit_example.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private Context context;
    private List<MovieModel> movieList;
    private ItemClickListener clickListener;

    public MovieListAdapter(Context context, List<MovieModel> movieList,ItemClickListener clickListener) {
        this.context = context;
        this.movieList = movieList;
        this.clickListener=clickListener;
    }
    public void setMovieList(List<MovieModel> movieList){
        this.movieList=movieList;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.price.setText(movieList.get(position).getPrice()+"$");
        holder.title.setText(movieList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onMovieClick(movieList.get(position));
            }
        });
        Glide.with(context).load(movieList.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.productImg);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,price;
        ImageView productImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            productImg=itemView.findViewById(R.id.productImg);
        }
    }
    public interface ItemClickListener{
        public void onMovieClick(MovieModel m);
    }
}
