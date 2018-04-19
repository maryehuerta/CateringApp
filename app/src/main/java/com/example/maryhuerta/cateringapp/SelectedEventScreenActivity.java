package com.example.maryhuerta.cateringapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectedEventScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_event_screen);
        Button AddResources = (Button) findViewById(R.id.AddResourcesButton);
        Button CancelEvent = (Button) findViewById(R.id.CancelEventButton);
        AddResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Resources Added", Toast.LENGTH_LONG).show();
            }
        });
        CancelEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Use the Builder class for convenient dialog construction
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectedEventScreenActivity.this);
                builder.setMessage("Are you sure you want to cancel?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(), "Event Cancelled", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
            }
        });
    }
    public void ViewAvailableHallsButtonClicked(View view) {

        Intent intent = new Intent(this, HallList.class);
        startActivity(intent);
    }
}

