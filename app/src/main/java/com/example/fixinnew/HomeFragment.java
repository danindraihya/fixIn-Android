package com.example.fixinnew;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.api.ApiRequestFotoBengkel;
import com.example.fixinnew.api.Retroserver;
import com.example.fixinnew.model.FotoBengkelModel;
import com.example.fixinnew.model.ResponsModelFotoBengkel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    SharedPrefManager sharedPrefManager;
    ApiRequestFotoBengkel api;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<FotoBengkelModel> mData = new ArrayList<>();
    public static HomeFragment ab;
    Button buttonBan, buttonMekanik;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        sharedPrefManager = new SharedPrefManager(view.getContext());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        api = Retroserver.getClient().create(ApiRequestFotoBengkel.class);
        ab=this;
        refresh();

        Button btn = (Button) view.findViewById(R.id.buttonBan);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
                System.out.println(view.getContext());
            }
        });

        return view;
    }

    public void refresh() {
        Call<ResponsModelFotoBengkel> getData = api.getFotoBengkel();
        getData.enqueue(new Callback<ResponsModelFotoBengkel>() {
            @Override
            public void onResponse(Call<ResponsModelFotoBengkel> call, Response<ResponsModelFotoBengkel> response) {
                Log.d("RETRO", "RESPONSE : " + response.body().getStatus());
                mData = response.body().getData();
                myAdapter = new MyAdapter(mData);
                mRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<ResponsModelFotoBengkel> call, Throwable t) {
            }
        });
    }
}
