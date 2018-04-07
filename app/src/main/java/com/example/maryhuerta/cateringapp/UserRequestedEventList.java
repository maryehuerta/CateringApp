package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by MaryHuerta on 3/25/2018.
 */

public class UserRequestedEventList extends AppCompatActivity implements RecyclerViewClickListener {

    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_requested_events);
        populateuserRequestedEventsTest();
    }

    private RecyclerView eventRecyclerView;
    private UserRequestedEventsAdapter adapter;
    ArrayList<UserRequestedEventItem> eventList = new ArrayList<>();

    public void populateuserRequestedEventsTest() {
        eventRecyclerView = (RecyclerView) findViewById(R.id.UserRequestedEventsRecyclerView);
        eventRecyclerView.setHasFixedSize(true);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserRequestedEventItem item = new UserRequestedEventItem("hello", "JOhn", "10/10/16", "10:00am", "2hr", "KC", "100", "Wedding", "Itailian", "dinner", "formal", "regular", "Beach Ball", "non reserved");

        eventList.add(new UserRequestedEventItem("john", "yo", "10/10/16", "10:00am", "2hr", "KC", "100", "Wedding", "Itailian", "dinner", "formal", "regular", "Beach Ball", "non reserved"));
        eventList.add(new UserRequestedEventItem("Smith", "JOhn", "10/10/18", "11:00am", "2hr", "NH", "200", "Wedding", "Itailian", "dinner", "formal", "regular", "Beach Ball", "non reserved"));
        eventList.add(item);
        Log.d("event list", eventList.toString());
        adapter = new UserRequestedEventsAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, UserRequestedEventDetails.class);
        UserRequestedEventItem item = adapter.getItem(position);
        intent.putExtra(ITEM, item);
        startActivityForResult(intent, SHOW_DETAIL);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SHOW_DETAIL) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

            }else{
                // the request was cancelled/unsuccessful
            }
        }
    }
}