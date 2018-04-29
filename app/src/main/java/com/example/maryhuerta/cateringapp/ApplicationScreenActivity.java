package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Miguel Gomez on 3/25/2018.
 */

public class ApplicationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_screen);

    }

    public void loginButtonClicked(View view) {

        finishAffinity();
        Intent newIntent = new Intent(getApplicationContext(), LoginScreenActivity.class);
        startActivity(newIntent);
    }

    public void RegisterButtonClicked(View view) {
        Intent intent = new Intent(this, RegistrationScreenActivity.class);
        startActivity(intent);

    }
}
