package com.example.maryhuerta.cateringapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by jimmy on 3/25/2018.
 */

public class HallList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_halls);
        populateHallsTest();
    }

    private RecyclerView HallRecyclerView;
    private RecyclerView.Adapter adapter;
    Vector<HallItem> hallList;

    public void populateHallsTest() {
        HallRecyclerView = (RecyclerView) findViewById(R.id.HallRecyclerView);
        HallRecyclerView.setHasFixedSize(true);
        HallRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        hallList = new Vector<>();
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "10:00"));
        }
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "10:30"));
        }
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "11:00"));
        }

        adapter = new HallAdapter(hallList, this);
        HallRecyclerView.setAdapter(adapter);

    }
}