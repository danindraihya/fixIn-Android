package com.example.fixinnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fixinnew.R;
import com.example.fixinnew.model.DataModel;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<DataModel> mList;
    private Context ctx;

    public  AdapterData (Context ctx, List<DataModel> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View Layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist, parent,false);
        HolderData holder = new HolderData(Layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.idbengkel.setText(Integer.toString(dm.getIDBENGKEL()));
        holder.jenisuser.setText(Integer.toString(dm.getJENISUSER()));
        holder.username.setText(dm.getUSERNAME());
        holder.password.setText(dm.getPASSWORD());
        holder.email.setText(dm.getEMAIL());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder {

        TextView idbengkel, jenisuser, username, password, email;

        public HolderData(View v)
        {
            super(v);

            idbengkel = (TextView) v.findViewById(R.id.tvidBengkel);
            jenisuser = (TextView) v.findViewById(R.id.tvjenisUser);
            username = (TextView) v.findViewById(R.id.tvusername);
            password = (TextView) v.findViewById(R.id.tvpassword);
            email = (TextView) v.findViewById(R.id.tvemail);
        }
    }

}

