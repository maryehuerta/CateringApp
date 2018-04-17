package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CatererEventSummaryActivity extends AppCompatActivity implements RecyclerViewClickListener {
    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterer_event_summary);

        // Called in onCreate function gives random test data to work with
        populateuserRequestedEventsTest();
    }


    private RecyclerView eventRecyclerView;
    private UserRequestedEventsAdapter adapter;
    ArrayList<UserRequestedEventItem> eventList = new ArrayList<>();

    public void populateuserRequestedEventsTest() {
        eventRecyclerView = (RecyclerView) findViewById(R.id.UserRequestedEventsRecyclerView);
        eventRecyclerView.setHasFixedSize(true);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Same data as User
        UserRequestedEventItem item = new UserRequestedEventItem("Brown", "Larry", "10/10/17", "11:00am", "2hr", "Arlington", "4", "Wedding", "Itailian", "dinner", "formal", "regular", "None", "reserved");

        eventList.add(new UserRequestedEventItem("Hastings", "Cam", "1/1/18", "5:00pm", "3hr", "KC", "111", "Graduation", "American", "Brunch", "Casual", "regular", "Beach Ball", "non reserved"));
        eventList.add(new UserRequestedEventItem("Smith", "John", "12/10/17", "11:00am", "2hr", "NH", "200", "Wedding", "Itailian", "dinner", "formal", "regular", "Beach Ball", "non reserved"));
        eventList.add(item);
        Log.d("event list", eventList.toString());
        adapter = new UserRequestedEventsAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }
    //When an Item in the list is clicked this function is triggered
    @Override
    public void recyclerViewListClicked(View v, int position) {
        //Makes a toast of the item's position in the list
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        //Create an intent
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
