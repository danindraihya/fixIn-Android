package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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

public class ActivityBeranda extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    ApiRequestFotoBengkel api;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<FotoBengkelModel> mData = new ArrayList<>();
    public static ActivityBeranda ab;
    Button buttonBan, buttonMekanik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        sharedPrefManager = new SharedPrefManager(this);
        buttonBan = (Button) findViewById(R.id.buttonBan);
        buttonMekanik = (Button) findViewById(R.id.buttonMekanik);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        api = Retroserver.getClient().create(ApiRequestFotoBengkel.class);
        ab=this;
        refresh();

        buttonBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(sharedPrefManager.getSpStnk());
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(ActivityBeranda.this, ActivityLogin.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

        buttonMekanik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Maps.class);
                startActivity(startIntent);
            }
        });


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
