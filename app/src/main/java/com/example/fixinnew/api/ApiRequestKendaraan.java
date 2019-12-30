package com.example.fixinnew.api;

import com.example.fixinnew.model.ResponsKendaraanModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiRequestKendaraan {

    @GET("kendaraan/cariKendaraan")
    Call<ResponsKendaraanModel> getKendaraan(@Field("noStnk") String noStnk);
}
