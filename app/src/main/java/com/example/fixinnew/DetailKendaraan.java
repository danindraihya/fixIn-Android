package com.example.fixinnew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailKendaraan extends AppCompatActivity {

    Button btnBack;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kendaraan);

        btnBack = (Button) findViewById(R.id.buttonBack);
        tv = (TextView) findViewById(R.id.tvTipeMotor);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("HAHAHAHAAHAHAHAHAHA");
            }
        });

    }
}
