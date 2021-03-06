package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CatererSelectedUserRequestActivity extends AppCompatActivity {

    Button ApprovedSelectedUserRequestButton;
    Button CreateCateredEventPlanButton;
    String eventName = null;
    String UserID;
    UserRequestedEventItem item;
    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    // TODO: return results/actions to be taken to parent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_requested_event_details);

        Bundle data = getIntent().getExtras();
        item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventsActivity.ITEM);
        String [] UserInfo = getIntent().getStringExtra("USERINFO").split(";");
        UserID= UserInfo[0];

        if (item != null){
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
            eventDateTextView.setText(item.getStartTime());
            durationTextView.setText(item.getDuration());
            hallNameTextView.setText(item.getHallName());
            eventNameTextView.setText(item.getEventName());


        }
        ApprovedSelectedUserRequestButton = (Button) findViewById(R.id.ApproveSelectedUserRequestButton);
        CreateCateredEventPlanButton = (Button) findViewById(R.id.CreateCateredEventPlanButton);

        ApprovedSelectedUserRequestButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager handler = new DBManager(CatererSelectedUserRequestActivity.this);
                boolean available = true;
                for (EventModel events : handler.getAllEvents()){
                    if (events.getCatererID().equals(UserID)){
                        if (events.getDate().equals(item.getDate())) {

                            int startTimeList = Integer.parseInt(events.getTimeOfEvent());
                            int durationList = Integer.parseInt(events.getDuration());
                            int endtimeList = startTimeList + durationList;

                            int startTimeCurr = Integer.parseInt(item.getStartTime());
                            int durrationCurr = Integer.parseInt(item.getDuration());
                            int endtimeCurr = startTimeCurr + durrationCurr;

                            if (startTimeCurr == startTimeList) {
                                available = false;
                            } else if (!(endtimeList <= startTimeCurr || startTimeList >= endtimeCurr)) {
                                available = false;
                            }
                        }
                    }
                }
                String toast;
                if (available){
                    handler.approveSelectedUserrequest(eventName, UserID);
                    toast = "Request Approved!";
                }
                else{
                    toast = "Error: Already scheduled Event for this time";
                }
                Toast.makeText(CatererSelectedUserRequestActivity.this  , toast, Toast.LENGTH_LONG).show();
                finish();

            }
        });



        CreateCateredEventPlanButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager handler = new DBManager(CatererSelectedUserRequestActivity.this);
                handler.approveSelectedUserrequest(eventName, UserID);
                Toast.makeText(CatererSelectedUserRequestActivity.this  , "Caterer Event Created!", Toast.LENGTH_LONG).show();

                finish();


            }
        });


    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);

    }
}
