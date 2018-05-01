package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CatererSelectedEventScreenActivity extends AppCompatActivity {
    Button CancelSelectedCatererEventButton;

    String eventName = null;
    public static final String ITEM = "ITEM";
    public static final String EVENT_NAME = "EVENT_NAME";

    public final int SHOW_DETAIL = 1;
    UserRequestedEventItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterer_selected_event_screen);


        Bundle data = getIntent().getExtras();
        item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventsActivity.ITEM);
        if (item != null) {
            Log.d("UserDetails", item.getFirstName());
            TextView lastNameTextView = findViewById(R.id.LastName);
            TextView firstNameTextView = findViewById(R.id.FirstName);
            TextView eventDateTextView = findViewById(R.id.Date);
            TextView durationTextView = findViewById(R.id.duration);
            TextView hallNameTextView = findViewById(R.id.HallName);
            TextView eventNameTextView = findViewById(R.id.EventName);
//            TextView dateTextView = findViewById(R.id.date);
            TextView startTimeTextView = findViewById(R.id.StartTime);
            TextView attendeesTextView = findViewById(R.id.estAttendees);
            TextView foodTypeTextView = findViewById(R.id.FoodType);
            TextView MealTextView = findViewById(R.id.Meal);
            TextView MealFormailtyTextView = findViewById(R.id.MealFormality);
            TextView DrinkTypeTextView = findViewById(R.id.DrinkType);
            TextView EntertainmentItemsTextView = findViewById(R.id.EntertainmentItems);
            TextView CostField = findViewById((R.id.CostField));


//            dateTextView.setText(item.getDate());
            startTimeTextView.setText(item.getStartTime());
            attendeesTextView.setText(item.getEstAttendees());
            foodTypeTextView.setText(item.getFoodType());
            MealTextView.setText(item.getMeal());
            MealFormailtyTextView.setText(item.getMealFormality());
            DrinkTypeTextView.setText(item.getDrinkType());
            EntertainmentItemsTextView.setText(item.getEntertainmentItems());
            lastNameTextView.setText(item.getLastName());
            firstNameTextView.setText(item.getFirstName());
            eventDateTextView.setText(item.getDate());
            durationTextView.setText(item.getDuration());
            hallNameTextView.setText(item.getHallName());
            eventNameTextView.setText(item.getEventName());
            eventName = item.getEventName();




        }
        CancelSelectedCatererEventButton = (Button) findViewById(R.id.CancelEventButton);


        CancelSelectedCatererEventButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager handler = new DBManager(CatererSelectedEventScreenActivity.this);
                handler.cancelSelectedCatererEvent(eventName);
                Toast.makeText(CatererSelectedEventScreenActivity.this  , "Caterer Event Cancelled!", Toast.LENGTH_LONG).show();
                finish();


            }
        });
    }


    public void ViewAvailableStaffButtonClicked(View view) {
        Intent intent = new Intent(this, AvailableStaffActivity.class);
        intent.putExtra(ITEM, item);
        startActivityForResult(intent, SHOW_DETAIL);

    }


    public void AddResourcesButtonClicked(View view) {
        Intent intent = new Intent(this, CatererAddResourcesScreenActivity.class);
        intent.putExtra(EVENT_NAME, eventName);
        startActivityForResult(intent, SHOW_DETAIL);

    }


    public void ViewAvailableHallsButtonClicked(View view) {
        Intent intent = new Intent(this, HallList.class);
        intent.putExtra(EVENT_NAME, eventName);
        startActivityForResult(intent, SHOW_DETAIL);

    }



    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SHOW_DETAIL) {
            // Make sure the request was successful
            
            finish();
        }

    }
}

