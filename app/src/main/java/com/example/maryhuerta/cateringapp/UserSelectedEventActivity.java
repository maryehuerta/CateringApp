package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class UserSelectedEventActivity extends AppCompatActivity {
    String eventName = null;
    Button cancelSelectedUserEventButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected_event);

        Bundle data = getIntent().getExtras();
        UserRequestedEventItem item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventsActivity.ITEM);
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


            eventName = item.getEventName();

//            dateTextView.setText(item.getDate());
            startTimeTextView.setText(item.getStartTime());
            attendeesTextView.setText(item.getEstAttendees());
            foodTypeTextView.setText(item.getFoodType());
            MealTextView.setText(item.getMeal());
            MealFormailtyTextView.setText(item.getMealFormality());
            DrinkTypeTextView.setText("Non-Alcoholic");
            EntertainmentItemsTextView.setText(item.getEntertainmentItems());
            lastNameTextView.setText(item.getLastName());
            firstNameTextView.setText(item.getFirstName());
            eventDateTextView.setText(item.getDate());
            durationTextView.setText(item.getDuration());
            hallNameTextView.setText(item.getHallName());
            eventNameTextView.setText(item.getEventName());

        }

        cancelSelectedUserEventButton = (Button) findViewById(R.id.CancelEventButton);


        cancelSelectedUserEventButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager handler = new DBManager(UserSelectedEventActivity.this);
                handler.cancelSelectedUserEvent(eventName);
                Toast.makeText(UserSelectedEventActivity.this  , "Caterer Event Cancelled!", Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

}
