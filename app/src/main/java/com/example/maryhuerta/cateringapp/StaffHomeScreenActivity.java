package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class StaffHomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_home_screen);
    }

    public void ViewStaffEventSummaryButtonClicked(View view) {

        Intent intent = new Intent(this, StaffEventSummaryActivity.class);
        startActivity(intent);
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }

}