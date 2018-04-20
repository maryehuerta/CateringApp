package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CatererAddResourcesScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caterer_add_resources_screen);
    }

    public void AddResourceDoneButtonClicked(View view) {

        Intent intent = new Intent(this, CatererHomeScreenActivity.class);
        startActivity(intent);
    }

}
