package com.example.newspaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public NewsRVAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return  new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
        Articles articles=articlesArrayList.get(position);
        holder.subtitletv.setText(articles.getDescription());
        holder.titletv.setText(articles.getTitle());
        Picasso.get().load(articles.getUrltoImage()).into(holder.newsiv);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( context, NewsDetailActivity.class);
                intent.putExtra("title",articles.getTitle());
                intent.putExtra("content",articles.getContent());
                intent.putExtra("description",articles.getDescription());
                intent.putExtra("image",articles.getUrltoImage());
                intent.putExtra("url",articles.getUrl());
                context.startActivities(new Intent[]{intent});
            }
        });


    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titletv,subtitletv;
        private ImageView newsiv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titletv=itemView.findViewById(R.id.tvnewsheading);
            subtitletv=itemView.findViewById(R.id.tvsubhead);
            newsiv=itemView.findViewById(R.id.ivnews);

        }
    }
}
