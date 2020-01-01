package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class pilih extends AppCompatActivity {

    ImageView buttonMobil, buttonMotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih);

        buttonMobil = (ImageView) findViewById(R.id.buttonMobil);

        buttonMotor = (ImageView) findViewById(R.id.buttonMotor);

        buttonMobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InputStnk.class);
                startActivity(startIntent);
            }
        });



    }
}
