package com.example.newspaper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {

    private ArrayList<CategoryRvModel> categoryRvModels;
    private Context context;
    private CategoryClickInterface categoryClickInterface;

    public CategoryRVAdapter(ArrayList<CategoryRvModel> categoryRvModels, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryRvModels = categoryRvModels;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        return new CategoryRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.ViewHolder holder,int position) {
        CategoryRvModel categoryRvModel=categoryRvModels.get(position);
        holder.cattv.setText(categoryRvModel.getCategory());
        Picasso.get().load(categoryRvModel.getCategoryImageUrl()).into(holder.cativ);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onCategoryClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryRvModels.size();
    }

    public  interface CategoryClickInterface{
        void onCategoryClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cattv;
        private ImageView cativ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cativ=itemView.findViewById(R.id.ivcat);
            cattv=itemView.findViewById(R.id.tvcat);
        }
    }
}
