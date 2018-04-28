package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CatererAddResourcesScreenActivity extends AppCompatActivity {
    Button DoneButton;

    EditText FoodVenueText, mealTypeText, drinkTypeText, EntertainmentItemsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final String event_name = intent.getStringExtra("EVENT_NAME");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.caterer_add_resources_screen);
        FoodVenueText = (EditText) findViewById(R.id.FoodVenueText);
        mealTypeText = (EditText) findViewById(R.id.mealTypeText);
        drinkTypeText = (EditText) findViewById(R.id.drinkTypeText);
        EntertainmentItemsText = (EditText) findViewById(R.id.EntertainmentItemsText);
        DoneButton = findViewById(R.id.DoneButton);

        DoneButton.setOnClickListener( new View.OnClickListener() {
            @Override public void onClick(View view) {
                String FoodVenue = FoodVenueText.getText().toString();
                String MealTypeText = mealTypeText.getText().toString();
                String DrinkTypeText = drinkTypeText.getText().toString();
                String entertainmentItemsText = EntertainmentItemsText.getText().toString();

                DBManager handler = new DBManager(CatererAddResourcesScreenActivity.this);
                handler.addResources(event_name, FoodVenue, MealTypeText, DrinkTypeText, entertainmentItemsText);
                Toast.makeText(CatererAddResourcesScreenActivity.this  , "Resources Added!", Toast.LENGTH_LONG).show();
                finish();

            }

        } );



    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

}
