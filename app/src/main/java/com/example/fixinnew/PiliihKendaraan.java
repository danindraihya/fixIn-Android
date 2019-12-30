package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PiliihKendaraan extends AppCompatActivity {

    Button buttonMobil, buttonMotor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piliih_kendaraan);

        buttonMobil = (Button) findViewById(R.id.buttonMobil);
        buttonMotor = (Button) findViewById(R.id.buttonMotor);

        buttonMobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                Intent startIntent = new Intent(getApplicationContext(), InputStnk.class);
                startActivity(startIntent);
            }
        });

        buttonMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                Intent startIntent = new Intent(getApplicationContext(), InputStnk.class);
                startActivity(startIntent);
            }
        });

    }
}
