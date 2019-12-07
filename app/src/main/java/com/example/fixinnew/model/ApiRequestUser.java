package com.example.fixinnew.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestUser {

    @FormUrlEncoded
    @POST("users")
    Call<ResponsModel> sendUser(@Field("idBengkel") Integer idBengkel,
                                     @Field("jenisUser") Integer jenisUser,
                                     @Field("username") String username,
                                     @Field("password") String password,
                                     @Field("email") String email);

}
