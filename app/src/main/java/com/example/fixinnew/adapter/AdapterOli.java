package com.example.fixinnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.R;
import com.example.fixinnew.model.DataLayanan;

import java.util.List;

public class AdapterOli extends RecyclerView.Adapter<AdapterOli.ViewHolder> {

    Context c;
    List<DataLayanan> models;

    public AdapterOli(List<DataLayanan> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kerusakan_oli, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mDes.setText(models.get(position).getDeskripsi_layanan());
        holder.mHarga.setText(Integer.toString(models.get(position).getHarga_layanan()));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mDes, mHarga, lihatBengkel;
        ImageView button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mDes = itemView.findViewById(R.id.tvDes);
            this.mHarga = itemView.findViewById(R.id.tvHarga);
        }
    }


}
