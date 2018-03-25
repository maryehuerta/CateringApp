package com.example.maryhuerta.cateringapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class RegistrationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_halls);
        if (true) {
            populateHallsTest();
        }
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
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100,"10:30"));
        }
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "11:00"));
        }

        adapter = new HallAdapter(hallList, this);
        HallRecyclerView.setAdapter(adapter);

    }
}
