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
    public static final String EVENT_NAME = "EVENT_NAME";
    String eventName = null;
    Button cancelSelectedUserEventButton;
    UserRequestedEventItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected_event);

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


            int RoomCost = 0;
            int RoomRate = 2;
            if (item.getHallName().equals("Maverick")){
                RoomCost = 100;
            }
            else if (item.getHallName().equals("KC")){
                RoomCost = 25;
            }
            else if (item.getHallName().equals("Arlington")){
                RoomCost = 50;
            }
            else if (item.getHallName().equals("Shard")){
                RoomCost = 25;
            }
            else if (item.getHallName().equals("Liberty")){
                RoomCost = 75;
            }

            int MealRate = 0;
            if (item.getMeal().equals("Breakfast")){
                MealRate = 8;
            }
            else if (item.getMeal().equals("Lunch")){
                MealRate = 12;
            }
            else if (item.getMeal().equals("Supper")){
                MealRate = 18;
            }

            int MealCost = MealRate*Integer.parseInt(item.getEstAttendees());

            if (item.getMealFormality().equals("Formal")){
                MealCost*=1.5;
            }

            int totalCost = (RoomCost*RoomRate*Integer.parseInt(item.getDuration())) + MealCost;



            if (item.getDrinkType().equals("Alcoholic")){
                totalCost+= Integer.parseInt(item.getEstAttendees())*15;
            }
            CostField.setText("$ " + totalCost);

        }


        cancelSelectedUserEventButton = (Button) findViewById(R.id.CancelEventButton);
        cancelSelectedUserEventButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager handler = new DBManager(UserSelectedEventActivity.this);
                handler.cancelSelectedUserEvent(eventName);
                Toast.makeText(UserSelectedEventActivity.this  , "User Event Cancelled!", Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

    public void  ViewHallsButtonClicked(View view){
        Intent intent = new Intent(this, HallList.class);
        intent.putExtra(EVENT_NAME, eventName);
        startActivity(intent);
    }

}
