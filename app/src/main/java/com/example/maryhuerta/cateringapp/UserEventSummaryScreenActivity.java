package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class UserEventSummaryScreenActivity extends AppCompatActivity implements RecyclerViewClickListener {
    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;

    String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_event_summary_screen);

        /**/
        String [] UserInfo = getIntent().getStringExtra("USERINFO").split(";");
        UserID= UserInfo[0];
        /**/


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
        DBManager handler = new DBManager(UserEventSummaryScreenActivity.this);
        eventList.clear();
        for (EventModel model: handler.getAllEvents()){
           // System.out.println("THE USER IS: "+ UserID);
            if (UserID.equals(model.getUserID())) {
                eventList.add(new UserRequestedEventItem(model.getLastName(), model.getFirstName(), model.getDate(), model.getTimeOfEvent(), model.getDuration(), model.getHallName(), model.getAttendees(), model.getEventName(), model.getFoodType(), model.getMealType(), model.getFormality(), "DrinkType", model.getSpecialItems(), model.getReserved()));
            }
        }
        Log.d("event list", eventList.toString());
        adapter = new UserRequestedEventsAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }

    //When an Item in the list is clicked this function is triggered
    @Override
    public void recyclerViewListClicked(View v, int position) {
        //Create an intent
        Intent intent = new Intent(this, UserSelectedEventActivity.class);
        UserRequestedEventItem item = adapter.getItem(position);
        intent.putExtra(ITEM, item);
        startActivityForResult(intent, SHOW_DETAIL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SHOW_DETAIL) {
            populateuserRequestedEventsTest();


            if (resultCode == RESULT_OK) {

            } else {
                // the request was cancelled/unsuccessful
            }
        }
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
        this.finish();
    }

}

