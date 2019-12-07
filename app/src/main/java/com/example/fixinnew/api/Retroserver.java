package com.example.fixinnew.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver {

    private static final String base_url = "http://192.168.1.2/fixIn/api/";

    private static Retrofit retrofit;


    public static Retrofit getClient()
    {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}