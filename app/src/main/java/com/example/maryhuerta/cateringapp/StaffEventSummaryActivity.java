package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class StaffEventSummaryActivity extends AppCompatActivity implements RecyclerViewClickListener  {
    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;
    String UserID, UserType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_event_summary_screen);
        String [] UserInfo = getIntent().getStringExtra("USERINFO").split(";");
        UserID= UserInfo[0];
        UserType = UserInfo[1];
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

        // Pulls from DB Manager

        DBManager handler = new DBManager(StaffEventSummaryActivity.this);
        eventList.clear();
        for (EventModel model: handler.getStaffEvents(UserID)){
            System.out.println(model.getEventName());
            eventList.add(new UserRequestedEventItem(model.getLastName(),model.getFirstName(),model.getDate(),model.getTimeOfEvent(), model.getDuration(),model.getHallName(),model.getAttendees(),model.getEventName(), model.getFoodType(), model.getMealType(), model.getFormality(), model.getDrinkType(), model.getSpecialItems(), model.getReserved()));
        }
        adapter = new UserRequestedEventsAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }
    //When an Item in the list is clicked this function is triggered
    @Override
    public void recyclerViewListClicked(View v, int position) {
        //Create an intent
        Intent intent = new Intent(this, StaffSelectedEventSummary.class);
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

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }
}
