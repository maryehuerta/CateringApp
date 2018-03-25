package com.example.maryhuerta.cateringapp;

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


        Button LoginBtn = (Button) findViewById(R.id.ApplicationLoginBtn);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}
