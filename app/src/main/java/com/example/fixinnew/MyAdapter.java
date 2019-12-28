package com.example.fixinnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.model.FotoBengkelModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    List<FotoBengkelModel> models;
    List<Model> mItems;

    public MyAdapter(List<FotoBengkelModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


        holder.mTitle.setText(models.get(position).getAlamat());
//        holder.mDes.setText(Integer.toString(models.get(position).getIdbengkel()));
        Picasso.get().load("http://192.168.1.11/fixIn/foto/" + models.get(position).getFoto()).into(holder.mImageView);

//
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
