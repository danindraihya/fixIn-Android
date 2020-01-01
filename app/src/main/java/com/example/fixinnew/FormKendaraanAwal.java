package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FormKendaraanAwal extends AppCompatActivity {

    Button buttonSelesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kendaraan_awal);

        buttonSelesai = (Button) findViewById(R.id.buttonSelesai);

        buttonSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(startIntent);
            }
        });
    }
}
