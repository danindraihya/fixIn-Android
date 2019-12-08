package com.example.fixinnew.api;

import com.example.fixinnew.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestUser {

    @FormUrlEncoded
    @POST("users")
    Call<ResponsModel> sendUser(@Field("idbengkel") Integer idBengkel,
                                @Field("jenisuser") Integer jenisUser,
                                @Field("username") String username,
                                @Field("password") String password,
                                @Field("email") String email);

    @GET("users")
    Call<ResponsModel> getUser();

}
