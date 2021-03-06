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
    EditText eventName, firstName, lastName, attendees, timeOfEvent, duration, dateOfEvent, specialItems;
    RadioGroup formality, foodType, mealType, drinkType;
    Button createEventButton;

    /**/
    String UserID;
    /**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_request_event_screen);
        eventName = (EditText) findViewById(R.id.editText1);
        firstName = (EditText) findViewById(R.id.editText1_1);
        lastName = (EditText) findViewById(R.id.editText1_2);
        dateOfEvent = (EditText) findViewById(R.id.editText6);
        duration = (EditText) findViewById(R.id.editText5);
        timeOfEvent = (EditText) findViewById(R.id.editText3);
        //hallname
        attendees = (EditText) findViewById(R.id.editText2);
        foodType = (RadioGroup) findViewById(R.id.radioGroup2);
        formality = (RadioGroup) findViewById(R.id.radioGroup);
        mealType = (RadioGroup) findViewById(R.id.radioGroup1);
        drinkType = (RadioGroup) findViewById(R.id.radioGroup_1);
        //reserved
        specialItems = (EditText) findViewById(R.id.editText8);
        createEventButton = (Button) findViewById(R.id.RequestBtn);

        final String [] UserInfo = getIntent().getStringExtra("USERINFO").split(";");
        UserID= UserInfo[0];


        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventModel event = new EventModel();
                event.setHallName("None");
                event.setReserved("No");
                event.setEventName(eventName.getText().toString());
                event.setFirstName(firstName.getText().toString());
                event.setLastName(lastName.getText().toString());
                event.setDate(dateOfEvent.getText().toString());
                event.setDuration(duration.getText().toString());
                event.setTimeOfEvent(timeOfEvent.getText().toString());
                event.setAttendees(attendees.getText().toString());
                event.setSpecialItems(specialItems.getText().toString());
                event.setCatererID("NO_CATERER_ASSIGNED");
                event.setUserID(UserID);
                int bleh = foodType.getCheckedRadioButtonId();
                switch(bleh)
                {
                    case R.id.American:
                        event.setFoodType("American");
                        break;
                    case R.id.Chinese:
                        event.setFoodType("Chinese");
                        break;
                    case R.id.French:
                        event.setFoodType("French");
                        break;
                    case R.id.radioButton13:
                        event.setFoodType("Greek");
                        break;
                    case R.id.radioButton14:
                        event.setFoodType("Indian");
                        break;
                    case R.id.radioButton15:
                        event.setFoodType("Japanese");
                        break;
                    case R.id.radioButton16:
                        event.setFoodType("Mexican");
                        break;
                    case R.id.radioButton17:
                        event.setFoodType("Pizza");
                        break;
                }
                int bleh1 = mealType.getCheckedRadioButtonId();
                switch(bleh1)
                {
                    case R.id.breakfast:
                        event.setMealType("Breakfast");
                        break;
                    case R.id.lunch:
                        event.setMealType("Lunch");
                        break;
                    case R.id.supper:
                        event.setMealType("Supper");
                        break;
                }

                int bleh1_1 = drinkType.getCheckedRadioButtonId();
                switch(bleh1_1)
                {
                    case R.id.formal_1:
                        event.setDrinkType("Alcoholic");
                        break;
                    case R.id.informal_1:
                        event.setDrinkType("Non-Alcoholic");
                        break;
                }

                int bleh2 = formality.getCheckedRadioButtonId();
                switch(bleh2)
                {
                    case R.id.formal:
                        event.setFormality("Formal");
                        break;
                    case R.id.informal:
                        event.setFormality("Informal");
                        break;
                }

                if (event.getTimeOfEvent().equals("22") ||
                        event.getTimeOfEvent().equals("23") ||
                        event.getTimeOfEvent().equals("0") ||
                        event.getTimeOfEvent().equals("1") ||
                        event.getTimeOfEvent().equals("2") ||
                        event.getTimeOfEvent().equals("3") ||
                        event.getTimeOfEvent().equals("4") ||
                        event.getTimeOfEvent().equals("5") ||
                        event.getTimeOfEvent().equals("6") ) {

                    Toast.makeText(UserRequestEventScreenActivity.this  , "Unable to Request: Hall not open at that start time", Toast.LENGTH_LONG).show();

                } else if (event.getDuration().equals("1")) {
                    Toast.makeText(UserRequestEventScreenActivity.this  , "Unable to Request: Duration should be minimum 2 hours", Toast.LENGTH_LONG).show();

                } else {
                    DBManager handler = new DBManager(UserRequestEventScreenActivity.this);
                    handler.addNewEvent(event);
                    Toast.makeText(UserRequestEventScreenActivity.this  , "Request Recorded!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UserRequestEventScreenActivity.this  , UserHomeScreenActivity.class);
                    finish();

                }


            }
        });
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

/* If toast doesn't stay on screen, we can use this for the request button instead
    public void RequestBtnClicked(View view) {

        Intent intent = new Intent(this, UserHomeScreenActivity.class);
        startActivity(intent);
    }
*/

}
