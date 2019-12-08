package com.example.fixinnew;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fixinnew.api.Retroserver;
import com.example.fixinnew.api.ApiRequestUser;
import com.example.fixinnew.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Buatakun extends AppCompatActivity {

    Integer idBengkel, jenisUser;
    EditText username, email, password;
    Button buttonDaftar;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buatakun);

        username = (EditText) findViewById(R.id.inputUsername);
        email = (EditText) findViewById(R.id.inputEmail);
        password = (EditText) findViewById(R.id.inputPassword);
        buttonDaftar = (Button) findViewById(R.id.buttonDaftar);
        pd = new ProgressDialog(this);

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd.setMessage("Send Data ...");
                pd.setCancelable(false);
                pd.show();


                jenisUser = 1;
                String susername = username.getText().toString();
                String semail = email.getText().toString();
                String spassword = password.getText().toString();

                ApiRequestUser api = Retroserver.getClient().create(ApiRequestUser.class);

                Call<ResponsModel> sendData = api.sendUser(idBengkel, jenisUser, susername, spassword, semail);
                sendData.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String status = response.body().getStatus();

                        if(status.equalsIgnoreCase("true")) {
                            Toast.makeText(Buatakun.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Buatakun.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {

                        pd.hide();
                        Log.d("RETRO", "Failure : " + "Gagal mengirim request");
                    }
                });



            }
        });


    }
}
