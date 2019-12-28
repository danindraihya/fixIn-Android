package com.example.fixinnew;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Try extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        ImageView image = (ImageView) findViewById(R.id.cobaI);

        Picasso.get().load("http://192.168.52.1/fixIn/foto/stnk.png").into(image);

    }
}
