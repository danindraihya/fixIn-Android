//package com.example.fixinnew;
//
//import android.os.Bundle;
//import android.util.Log;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.fixinnew.adapter.AdapterData;
//import com.example.fixinnew.api.ApiRequestUser;
//import com.example.fixinnew.api.Retroserver;
//import com.example.fixinnew.model.DataModel;
//import com.example.fixinnew.model.ResponsModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class TampilData extends AppCompatActivity {
//
//    private RecyclerView mRecycler;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mManager;
////    ProgressDialog pd;
//    private List<DataModel> mItems = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tampil_data);
//
////        pd = new ProgressDialog(this);
//        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
//        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mRecycler.setLayoutManager(mManager);
//
////        pd.setMessage("Loading...");
////        pd.setCancelable(false);
////        pd.show();
//
//        ApiRequestUser api = Retroserver.getClient().create(ApiRequestUser.class);
//        Call<ResponsModel> getData = api.getUser();
//        getData.enqueue(new Callback<ResponsModel>() {
//            @Override
//            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
////                pd.hide();
//                Log.d("RETRO", "RESPONSE : " + response.body().getStatus());
//
//                mItems = response.body().getData();
//
//                mAdapter = new AdapterData(TampilData.this, mItems);
//                mRecycler.setAdapter(mAdapter);
//                mAdapter.notifyDataSetChanged();
//
//                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
//                System.out.println(mItems.get(2).getUSERNAME());
//            }
//
//            @Override
//            public void onFailure(Call<ResponsModel> call, Throwable t) {
////                pd.hide();
//                Log.d("RETRO", "FAILED : respon gagal");
//
//            }
//        });
//
//
//    }
//}
