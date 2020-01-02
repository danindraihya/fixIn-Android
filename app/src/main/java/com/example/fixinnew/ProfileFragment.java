package com.example.fixinnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    SharedPrefManager sharedPrefManager;
    Button btnLogout, faq, hubungi, tentang, syarat, buttonUpgradeAkun;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        buttonUpgradeAkun = (Button) view.findViewById(R.id.buttonUpgradeAkun);
        btnLogout = (Button) view.findViewById(R.id.buttonLogout);
        faq = (Button) view.findViewById(R.id.buttonFaq);
        hubungi = (Button) view.findViewById(R.id.buttonHubungi);
        tentang = (Button) view.findViewById(R.id.buttonTentang);
        syarat = (Button) view.findViewById(R.id.buttonSyarat);
        sharedPrefManager = new SharedPrefManager(view.getContext());

        //upgrade
        buttonUpgradeAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(view.getContext(), ubah_profil.class);
                startActivity(startIntent);
            }
        }

        );


        //syarat
        syarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(view.getContext(), syaratKetentuan.class);
                startActivity(startIntent);
            }
        });

        //tentang
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(view.getContext(), TentangApl.class);
                startActivity(startIntent);
            }
        });

        //hubungi
        hubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(view.getContext(), HubungiKami.class);
                startActivity(startIntent);
            }
        });

        //faq
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(view.getContext(), FAQ.class);
                startActivity(startIntent);
            }
        });

        //button logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(view.getContext(), MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });

        return view;
    }
}
