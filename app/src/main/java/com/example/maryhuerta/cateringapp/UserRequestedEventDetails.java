/*I WAS HERE DESTROYING STUFF*/
package com.example.maryhuerta.cateringapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserRequestedEventDetails extends AppCompatActivity {

    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    // TODO: return results/actions to be taken to parent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_requested_event_details);

        Bundle data = getIntent().getExtras();
        UserRequestedEventItem item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventsActivity.ITEM);
        if (item != null){
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
}
