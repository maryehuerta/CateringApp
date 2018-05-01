package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

/**
 * Created by jimmy on 3/25/2018.
 */

public class HallList extends AppCompatActivity implements RecyclerViewClickListener {

    int year,month,day;
    EditText monthText, yearText, dayText;
    long FilterDate;
    Intent intent = getIntent();
    int Attendees=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final String event_name = intent.getStringExtra("EVENT_NAME");

        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        setContentView(R.layout.available_halls);
        hallList = new ArrayList<>();
        monthText = (EditText) findViewById(R.id.MonthEditText);
        yearText = (EditText) findViewById(R.id.YearEditText);
        dayText = (EditText) findViewById(R.id.DayEditText);
        String [] date = new SimpleDateFormat("MM/dd/yy", Locale.getDefault()).format(new Date()).split("/");
        monthText.setText(date[0]);
        dayText.setText(date[1]);
        yearText.setText(date[2]);
        Attendees = Integer.parseInt(getIntent().getStringExtra("CAPACITY"));
        FilterList();
    }

    private RecyclerView HallRecyclerView;
    private HallAdapter adapter;
    ArrayList<HallItem> hallList;

    public void populateHallsTest() {
        HallRecyclerView = (RecyclerView) findViewById(R.id.HallRecyclerView);
        HallRecyclerView.setHasFixedSize(true);
        HallRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        DBManager handler = new DBManager(HallList.this);
        ArrayList <EventModel> ReservedEvents = handler.getReservedEvents();
        ArrayList <HallModel> AllHalls = handler.getAllHalls();

        hallList.add(new HallItem("Name", "Capacity", "TimeSlot"));

        // hallList.add(new HallItem(AllHalls.get(1).getHallName(), AllHalls.get(1).getHallCapacity(), String.valueOf(100)));

        for (int i=0; i<24;i++){
            for (int j=0; j<AllHalls.size();j++){
                boolean print = true;
                    //Don't ask
                if (Integer.parseInt(AllHalls.get(j).getHallCapacity())<Attendees){
                    print = false;
                }
                else{
                    for (int k=0;k<ReservedEvents.size();k++){
                        if (ReservedEvents.get(k).getDate().equals(String.valueOf(FilterDate+i)) && AllHalls.get(j).getHallName().equals(ReservedEvents.get(k).getHallName())){
                            print = false;
                        }
                    }
                }
                    if (print){
                        hallList.add(new HallItem(AllHalls.get(j).getHallName(), AllHalls.get(j).getHallCapacity(), String.valueOf(i*100)));
                    }
                }

            }

        adapter = new HallAdapter(hallList, this, this);
        HallRecyclerView.setAdapter(adapter);

    }

    //Lazy copy and paste called in onCreate
    public void FilterList(){
        hallList.clear();
        year = Integer.parseInt(yearText.getText().toString());
        month = Integer.parseInt(monthText.getText().toString());
        day = Integer.parseInt(dayText.getText().toString());
        FilterDate = 1000000*year + 10000*month + 100*day;
        populateHallsTest();
    }

    //Button callback
    public void FilterList(View view){
        hallList.clear();
        year = Integer.parseInt(yearText.getText().toString());
        month = Integer.parseInt(monthText.getText().toString());
        day = Integer.parseInt(dayText.getText().toString());
        FilterDate = 1000000*year + 10000*month + 100*day;
        populateHallsTest();
    }


    @Override
    public void recyclerViewListClicked(View v, int position) {
        Intent intent = getIntent();
        final String event_name = intent.getStringExtra("EVENT_NAME");
        Toast.makeText(this  , "Hall Added!", Toast.LENGTH_LONG).show();
        HallItem item = adapter.getItem(position);
        DBManager handler = new DBManager(getApplicationContext());
        if (position > 0){
            String newDate = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
            // TODO: Add the event name to the class
            handler.updateEventHall(event_name, item.getHallName(), newDate);
            finish();
        }
    }

    public void LogoutButtonClicked(View view) {
        finishAffinity();
        Intent newIntent = new Intent(getApplicationContext(), LoginScreenActivity.class);
        startActivity(newIntent);
    }
}