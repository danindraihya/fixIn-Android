package com.example.fixinnew.api;

import com.example.fixinnew.model.ResponsLayanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestLayanan {

    @FormUrlEncoded
    @POST("layanan")
    Call<ResponsLayanan> getLayanan(@Field("id") Integer id);

    @FormUrlEncoded
    @POST("layanan/ban")
    Call<ResponsLayanan> getBan();

    @FormUrlEncoded
    @POST("layanan/oli")
    Call<ResponsLayanan> getOli();

    @FormUrlEncoded
    @POST("layanan/aki")
    Call<ResponsLayanan> getAki();

    @FormUrlEncoded
    @POST("layanan/sparepart")
    Call<ResponsLayanan> getSparepart();

    @FormUrlEncoded
    @POST("layanan/mekanik")
    Call<ResponsLayanan> getMekanik();

    @FormUrlEncoded
    @POST("layanan/aksesoris")
    Call<ResponsLayanan> getAksesoris();

    @FormUrlEncoded
    @POST("layanan/cuci")
    Call<ResponsLayanan> getCuci();

    @FormUrlEncoded
    @POST("layanan/lainnya")
    Call<ResponsLayanan> getLainnya();

}
