package com.example.fixinnew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardView extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

//        RecyclerView myList = (RecyclerView) findViewById(R.id.recyclerView);
//        myList.setLayoutManager(layoutManager);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(layoutManager);

//        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);
//
//        m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);
//
//        m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);
//
//        m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);
//
//        m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);
//
//        m = new Model();
//        m.setTitle("News Feed");
//        m.setDescription("This is newsfeed description ...");
//        m.setImg(R.drawable.logo);
//        models.add(m);

        return models;

    }
}
