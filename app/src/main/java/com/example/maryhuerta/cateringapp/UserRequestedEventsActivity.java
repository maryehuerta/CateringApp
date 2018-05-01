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

/**
 * Created by MaryHuerta on 3/25/2018.
 */

public class UserRequestedEventsActivity extends AppCompatActivity implements RecyclerViewClickListener {

    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;
    String UserInfo, UserID, UserType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_requested_events);
        UserInfo = getIntent().getStringExtra("USERINFO");
        String SplitUserInfo [] = getIntent().getStringExtra("USERINFO").split(";");
        UserID=SplitUserInfo [0];
        UserType=SplitUserInfo [1];
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

        DBManager handler = new DBManager(UserRequestedEventsActivity.this);
        eventList.clear();
        for (EventModel model: handler.getAllEvents()){

           if (model.getReserved().toLowerCase().equals("no") && ((model.getCatererID().compareTo(UserID))!=0)){
               eventList.add(new UserRequestedEventItem(model.getLastName(),model.getFirstName(),model.getDate(),model.getTimeOfEvent(), model.getDuration(),model.getHallName(),model.getAttendees(),model.getEventName(), model.getFoodType(), model.getMealType(), model.getFormality(), model.getDrinkType(), model.getSpecialItems(), model.getReserved(), model.getStaff()));
           }
        }
        adapter = new UserRequestedEventsAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }
    //When an Item in the list is clicked this function is triggered
    @Override
    public void recyclerViewListClicked(View v, int position) {
        //Makes a toast of the item's position in the list
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        //Create an intent
        Intent intent = new Intent(this, CatererSelectedUserRequestActivity.class);
        UserRequestedEventItem item = adapter.getItem(position);
        intent.putExtra(ITEM, item);
        intent.putExtra("USERINFO", UserInfo);
        startActivityForResult(intent, SHOW_DETAIL);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SHOW_DETAIL) {
            // Make sure the request was successful
            populateuserRequestedEventsTest();
//                // the request was cancelled/unsuccessful
//            }
        }
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }


}