package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    //    ProgressDialog pd;
    private List<DataModel> mItems = new ArrayList<>();

    EditText username, password;

    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        pd = new ProgressDialog(this);
//        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
//        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mRecycler.setLayoutManager(mManager);

//        pd.setMessage("Loading...");
//        pd.setCancelable(false);
//        pd.show();

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        ApiRequestUser api = Retroserver.getClient().create(ApiRequestUser.class);
        Call<ResponsModel> getData = api.getUser();
        getData.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
//                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getStatus());

                mItems = response.body().getData();
//                mAdapter = new AdapterData(ActivityLogin.this, mItems);
//                mRecycler.setAdapter(mAdapter);
//                mAdapter.notifyDataSetChanged();


                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
                System.out.println(mItems.get(2).getUSERNAME());

            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
//                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;
                username = (EditText) findViewById(R.id.loginUsername);
                password = (EditText) findViewById(R.id.loginPassword);

                for(int i = 0; i < mItems.size(); i++) {
                    if(mItems.get(i).getUSERNAME().equalsIgnoreCase(username.getText().toString()) && mItems.get(i).getPASSWORD().equalsIgnoreCase(password.getText().toString())) {
//                        Toast.makeText(ActivityLogin.this, "Berhasil Login !", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(ActivityLogin.this, Onboarding1.class);
                        startActivity(startIntent);
                        flag = true;
                    }
                }

                if(flag == false) {
                    Toast.makeText(ActivityLogin.this, "Username / Password Salah !", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
