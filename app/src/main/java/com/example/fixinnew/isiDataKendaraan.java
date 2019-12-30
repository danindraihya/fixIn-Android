package com.example.fixinnew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class isiDataKendaraan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data_kendaraan);

//        ApiRequestKendaraan api = Retroserver.getClient().create(ApiRequestKendaraan.class);
//        Call<ResponsKendaraanModel> getKendaraan = api.getKendaraan(snoStnk);
//        getKendaraan.enqueue(new Callback<ResponsKendaraanModel>() {
//            @Override
//            public void onResponse(Call<ResponsKendaraanModel> call, Response<ResponsKendaraanModel> response) {
//                pd.hide();
//                response.body().getData();
//            }
//
//            @Override
//            public void onFailure(Call<ResponsKendaraanModel> call, Throwable t) {
//                pd.hide();
//            }
//        });

    }
}
