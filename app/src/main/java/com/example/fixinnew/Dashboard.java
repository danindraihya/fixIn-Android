package com.example.fixinnew;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.api.ApiRequestFotoBengkel;
import com.example.fixinnew.model.FotoBengkelModel;
import com.example.fixinnew.model.ResponsModelFotoBengkel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    ApiRequestFotoBengkel api;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<FotoBengkelModel> mData = new ArrayList<>();
    public static Dashboard ab;
    Button buttonBan, buttonMekanik;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Mapbox.getInstance(this, "pk.eyJ1IjoiZGFuaW5kcmEiLCJhIjoiY2szNzZ4Y3Z3MDlncjNrczFsc290bnI4aiJ9.hd2BKXV3iZWNQCOldxeZdA");

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
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

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_kendaraan:
                            selectedFragment = new KendaraanFragment();
                            break;
                        case R.id.nav_pengingat:
                            selectedFragment = new PengingatFragment();
                            break;
                        case R.id.nav_profil:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


}
