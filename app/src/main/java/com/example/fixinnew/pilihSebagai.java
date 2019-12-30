package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pilihSebagai extends AppCompatActivity {

    Button user;
    Button mitra;
    private int status;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_sebagai);
        sharedPrefManager = new SharedPrefManager(this);
        user = (Button) findViewById(R.id.user);
        mitra = (Button) findViewById(R.id.mitra);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPInt(SharedPrefManager.SP_STATUS, 1);
                Intent startIntent = new Intent(getApplicationContext(), Buatakun.class);
                startActivity(startIntent);
            }
        });

        mitra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPInt(SharedPrefManager.SP_STATUS, 2);
                Intent startIntent = new Intent(getApplicationContext(), Buatakun.class);
                startActivity(startIntent);
            }
        });

    }
}
