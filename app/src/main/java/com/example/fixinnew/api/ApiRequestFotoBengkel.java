package com.example.fixinnew.api;

import com.example.fixinnew.model.ResponsModelFotoBengkel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestFotoBengkel {

    @FormUrlEncoded
    @POST("foto_bengkel")
    Call<ResponsModelFotoBengkel> sendFotoBengkel(@Field("idbengkel") String idBengkel,
                                                  @Field("path") String path);

    @GET("foto_bengkel/rekomendasi")
    Call<ResponsModelFotoBengkel> getFotoBengkel();
}
