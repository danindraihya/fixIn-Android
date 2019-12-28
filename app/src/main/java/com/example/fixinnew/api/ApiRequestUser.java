package com.example.fixinnew.api;

import com.example.fixinnew.model.ResponsModel;
import com.example.fixinnew.model.ResponsModelFotoBengkel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestUser {

    @FormUrlEncoded
    @POST("users/register")
    Call<ResponsModel> sendUser(@Field("idbengkel") Integer idBengkel,
                                @Field("jenisuser") Integer jenisUser,
                                @Field("username") String username,
                                @Field("password") String password,
                                @Field("email") String email);

    @FormUrlEncoded
    @POST("users/login")
    Call<ResponsModel> loginUser(@Field("username") String username,
                                 @Field("password") String password);

    @GET("users")
    Call<ResponsModel> getUser();

    @GET("foto_bengkel")
    Call<ResponsModelFotoBengkel> getFotoBengkel();

}
