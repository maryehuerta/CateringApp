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


        DBManager handler = new DBManager(HallList.this);
        Vector <EventModel> ReservedEvents = handler.getReservedHalls();
        Vector <HallModel> AllHalls = handler.getAllHalls();

        hallList.add(new HallItem("Name", "Capacity", "TimeSlot"));

        int year = 18;
        int month = 12;
        int day = 19;
        long today = 1000000*year + 10000*month + 100*day;
        System.out.println("TODAY: " + today);


        for (int i=0; i<2;i++){
            for (int j=0; j<AllHalls.size();j++){
                boolean print = true;
                    for (int k=0;k<ReservedEvents.size();k++){
                        //System.out.println(ReservedEvents.get(k).getDate() + "  --  " + String.valueOf(today+i));
                        if (ReservedEvents.get(k).getDate().equals(String.valueOf(today+i)) && AllHalls.get(j).getHallName().equals(ReservedEvents.get(k).getEventName())){
                            System.out.println("HERE - " + today+i);
                            print = false;
                        }
                    }
                    if (print){
                        hallList.add(new HallItem(AllHalls.get(j).getHallName(), AllHalls.get(j).getHallCapacity(), String.valueOf(i*100)));
                    }
                }

            }

            /*String date = ReservedEvents.get(i).getDate();
            String [] dateP = date.split("/");
            int year = Integer.parseInt(dateP[2]);
            int month = Integer.parseInt(dateP[0]);
            int day = Integer.parseInt(dateP[1]);
            long intDate = 1000000*year + 10000*month + 100*day;
            long intDateMax = intDate + Integer.parseInt(ReservedEvents.get(i).getDuration());
            while (intDate < intDateMax){*/


        /*for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "10:00"));
        }
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "10:30"));
        }
        for (int i = 0; i < 10; i++) {
            hallList.add(new HallItem("Hall: " + i, "Capacity: " + i * 100, "11:00"));
        }*/

        adapter = new HallAdapter(hallList, this);
        HallRecyclerView.setAdapter(adapter);

    }
}