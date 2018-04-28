package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class UserHomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home_screen);
    }

    public void ViewUserEventSummaryButtonClicked(View view) {

        Intent intent = new Intent(this, UserEventSummaryScreenActivity.class);
        startActivity(intent);
    }

    public void RequestEventButtonClicked(View view) {

        Intent intent = new Intent(this, UserRequestEventScreenActivity.class);
        startActivity(intent);
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }


}
