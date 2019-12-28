package com.example.fixinnew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fixinnew.api.ApiRequestUser;
import com.example.fixinnew.api.Retroserver;
import com.example.fixinnew.model.DataModel;
import com.example.fixinnew.model.ResponsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    private List<DataModel> mItems = new ArrayList<>();
    private boolean status = false;
    Button buttonLogin;
    EditText username, password;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefManager = new SharedPrefManager(this);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        username = (EditText) findViewById(R.id.loginUsername);
        password = (EditText) findViewById(R.id.loginPassword);
        pd = new ProgressDialog(this);

        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(ActivityLogin.this, ActivityBeranda.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd.setMessage("Tunggu  ...");
                pd.setCancelable(false);
                pd.show();

                String susername = username.getText().toString();
                String spassword = password.getText().toString();

                ApiRequestUser api = Retroserver.getClient().create(ApiRequestUser.class);

                Call<ResponsModel> requestLogin = api.loginUser(susername, spassword);
                requestLogin.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        if(response.body().getStatus() == "true") {
                            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                            Intent startIntent = new Intent(getApplicationContext(), ActivityBeranda.class);
                            startActivity(startIntent);
                            pd.hide();
                        } else {
                            pd.hide();
                            Toast.makeText(ActivityLogin.this, "Gagal Login", Toast.LENGTH_LONG);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {

                    }
                });

            }
        });

    }

}
