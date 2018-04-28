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
            TextView lastNameTextView = findViewById(R.id.lastNameTextView);
            TextView firstNameTextView = findViewById(R.id.firstNameTextView);
            TextView eventDateTextView = findViewById(R.id.eventDateTextView);
            TextView durationTextView = findViewById(R.id.durationTextView);
            TextView hallNameTextView = findViewById(R.id.hallNameTextView);
            TextView eventNameTextView = findViewById(R.id.eventNameTextView);

            eventName = item.getEventName();

            lastNameTextView.setText(item.getLastName());
            firstNameTextView.setText(item.getFirstName());
            eventDateTextView.setText(item.getDate());
            durationTextView.setText(item.getDuration());
            hallNameTextView.setText(item.getHallName());
            eventNameTextView.setText(item.getEventName());

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

