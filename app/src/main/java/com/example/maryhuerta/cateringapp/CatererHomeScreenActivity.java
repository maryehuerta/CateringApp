package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class CatererHomeScreenActivity extends AppCompatActivity {

    String UserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caterer_home_screen);
        UserInfo = getIntent().getStringExtra("USERINFO");
    }

    public void ViewCatererEventSummaryButtonClicked(View view) {

        Intent intent = new Intent(this, CatererEventSummaryActivity.class);
        startActivity(intent);
    }

    public void ViewUserRequestsSummaryButtonClicked(View view) {

        Intent intent = new Intent(this, UserRequestedEventsActivity.class);
        intent.putExtra("USERINFO", UserInfo);
        startActivity(intent);
    }

    public void LogoutButtonClicked(View view) {

        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
    }
}