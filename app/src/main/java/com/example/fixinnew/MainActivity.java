package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMasuk;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);

        btnMasuk = (Button)findViewById(R.id.button);
        TextView clickdaftar = (TextView) findViewById(R.id.clickdaftar) ;
        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(MainActivity.this, Dashboard.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, PilihSebagaiLogin.class);
                startActivity(startIntent);
            }
        });

        clickdaftar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), pilihSebagai.class);
                startActivity(startIntent);
            }
        });
    }
}
