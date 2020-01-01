package com.example.fixinnew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.adapter.AdapterOli;
import com.example.fixinnew.api.ApiRequestLayanan;
import com.example.fixinnew.api.Retroserver;
import com.example.fixinnew.model.DataLayanan;
import com.example.fixinnew.model.ResponsLayanan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Oli extends AppCompatActivity {

    ApiRequestLayanan api;
    RecyclerView mRecyclerView;
    AdapterOli myAdapter;
    List<DataLayanan> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oli);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewOli);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        api = Retroserver.getClient().create(ApiRequestLayanan.class);
//        ab=this;
        refresh();

    }

    public void refresh() {
        Call<ResponsLayanan> getData = api.getLayanan(1);
        getData.enqueue(new Callback<ResponsLayanan>() {
            @Override
            public void onResponse(Call<ResponsLayanan> call, Response<ResponsLayanan> response) {
                mData = response.body().getData();
                myAdapter = new AdapterOli(mData);
                mRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<ResponsLayanan> call, Throwable t) {

            }
        });
    }
}
