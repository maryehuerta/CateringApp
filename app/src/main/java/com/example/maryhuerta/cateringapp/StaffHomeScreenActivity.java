package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class StaffHomeScreenActivity extends AppCompatActivity {

    UserModel userModel;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_home_screen);

        //how to get usermodel
        if (getIntent().hasExtra("USER")) {
            userModel = (UserModel) getIntent().getSerializableExtra("USER");
        }

        text = findViewById(R.id.bleh);
        text.setText("(delete later) welcome, " + userModel.getId());
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