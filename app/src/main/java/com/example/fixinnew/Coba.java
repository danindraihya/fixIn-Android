package com.example.fixinnew;

import android.util.Log;

import com.example.fixinnew.api.ApiRequestFotoBengkel;
import com.example.fixinnew.api.Retroserver;
import com.example.fixinnew.model.FotoBengkelModel;
import com.example.fixinnew.model.ResponsModelFotoBengkel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Coba {

    public List<FotoBengkelModel> mItems = new ArrayList<>();

    public Coba() {
        ApiRequestFotoBengkel api = Retroserver.getClient().create(ApiRequestFotoBengkel.class);
        Call<ResponsModelFotoBengkel> getData = api.getFotoBengkel();
        getData.enqueue(new Callback<ResponsModelFotoBengkel>() {
            @Override
            public void onResponse(Call<ResponsModelFotoBengkel> call, Response<ResponsModelFotoBengkel> response) {
                Log.d("RETRO", "RESPONSE : " + response.body().getStatus());
                mItems = response.body().getData();
            }

            @Override
            public void onFailure(Call<ResponsModelFotoBengkel> call, Throwable t) {

            }
        });

    }

    public void Cetak(){
        System.out.println(mItems);
    }


}
