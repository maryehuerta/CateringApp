package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class UserSelectedEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected_event);

        Bundle data = getIntent().getExtras();
        UserRequestedEventItem item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventsActivity.ITEM);
        if (item != null) {
            Log.d("UserDetails", item.getFirstName());
            TextView lastNameTextView = findViewById(R.id.lastNameTextView);
            TextView firstNameTextView = findViewById(R.id.firstNameTextView);
            TextView eventDateTextView = findViewById(R.id.eventDateTextView);
            TextView durationTextView = findViewById(R.id.durationTextView);
            TextView hallNameTextView = findViewById(R.id.hallNameTextView);
            TextView eventNameTextView = findViewById(R.id.eventNameTextView);


            lastNameTextView.setText(item.getLastName());
            firstNameTextView.setText(item.getFirstName());
            eventDateTextView.setText(item.getStartTime());
            durationTextView.setText(item.getDuration());
            hallNameTextView.setText(item.getHallName());
            eventNameTextView.setText(item.getEventName());


        }
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

}
