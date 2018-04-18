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

public class AvailableStaffActivity extends AppCompatActivity implements RecyclerViewClickListener  {
    public static final String ITEM = "ITEM";
    public final int SHOW_DETAIL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_staff);

        populateuserRequestedEventsTest();
    }



    private RecyclerView eventRecyclerView;
    private AvailableStaffAdapter adapter;
    ArrayList<HallAdapter.AvailableStaffItem> eventList = new ArrayList<>();

    public void populateuserRequestedEventsTest() {
        eventRecyclerView = (RecyclerView) findViewById(R.id.AvailableStaffRecyclerView);
        eventRecyclerView.setHasFixedSize(true) ;
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        HallAdapter.AvailableStaffItem item = new HallAdapter.AvailableStaffItem("Brown", "Larry","10/10/18", "1:00pm", "working");
        eventList.add(new HallAdapter.AvailableStaffItem("Jenkins", "John","10/10/18", "1:30pm", "working"));
        eventList.add(new HallAdapter.AvailableStaffItem("Huerta", "Mary","10/10/18", "1:30pm", "free"));
        eventList.add(new HallAdapter.AvailableStaffItem("Holmes", "Chris","10/10/18", "1:30pm", "working"));
        eventList.add(new HallAdapter.AvailableStaffItem("Swanson", "Abligale","10/10/18", "1:30pm", "working"));

        eventList.add(item);
        Log.d("event list", eventList.toString());
        adapter = new AvailableStaffAdapter(eventList, this, this);
        eventRecyclerView.setAdapter(adapter);

    }
    //When an Item in the list is clicked this function is triggered
    @Override
    public void recyclerViewListClicked(View v, int position) {
        Toast.makeText(this, String.valueOf(position + " was pressed. TODO send user back"), Toast.LENGTH_SHORT).show();
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
