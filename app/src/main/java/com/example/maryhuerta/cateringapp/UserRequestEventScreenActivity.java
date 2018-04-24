package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserRequestEventScreenActivity extends AppCompatActivity {
    EditText eventName, attendees, timeOfEvent, duration, dateOfEvent, specialItems;
    RadioGroup formality, foodType, drinkType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_request_event_screen);
        eventName = (EditText) findViewById(R.id.editText10);
        attendees = (EditText) findViewById(R.id.editText12);
        timeOfEvent = (EditText) findViewById(R.id.editText7);
        //duration = (EditText) findViewById(R.id.
        Button RequestBtn = (Button) findViewById(R.id.RequestBtn);
        RequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Request Recorded!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), UserHomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }

/* If toast doesn't stay on screen, we can use this for the request button instead
    public void RequestBtnClicked(View view) {

        Intent intent = new Intent(this, UserHomeScreenActivity.class);
        startActivity(intent);
    }
*/

}
