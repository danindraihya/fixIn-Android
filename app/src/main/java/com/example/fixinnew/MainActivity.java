package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMasuk = (Button)findViewById(R.id.button);
        TextView clickdaftar = (TextView) findViewById(R.id.clickdaftar) ;

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(startIntent);
            }
        });

        clickdaftar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Buatakun.class);
                startActivity(startIntent);
            }
        });
    }
}