package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Miguel Gomez on 3/25/2018.
 */

public class LoginScreenActivity extends AppCompatActivity {

    EditText username, password;
    Button LoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        LoginBtn = (Button) findViewById(R.id.LoginLoginBrn);
        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        //Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();

        //Test Users
        DBManager handler = new DBManager(LoginScreenActivity.this);
        handler.addNewUser(new UserModel("1001200000", "User", "Last", "original@gmail.com", "123", "UserTest", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "User"));
        handler.addNewUser(new UserModel("1001200001", "Caterer", "Last", "original@gmail.com", "123", "CatererTest", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Caterer"));
        handler.addNewUser(new UserModel("1001200002", "Staff", "Last", "original@gmail.com", "123", "StaffTest", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));
        handler.addNewUser(new UserModel("1001200003", "Staff 2", "Last", "original@gmail.com", "123", "StaffTest2", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));
        handler.addNewUser(new UserModel("1001200004", "Staff 3", "Last", "original@gmail.com", "123", "StaffTest3", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));

        //Test Events
        //handler.addNewEvent(new EventModel("OkParty", "Cam", "Hastings", "12/19/2018", "8:00", "2hr", "KC", "300", "Chinese",  "none", "Dinner", "no","Beach Ball"));
        //handler.addNewEvent(new EventModel("GreatParty", "Hastings", "Cam", "1/1/18", "5:00pm", "3hr", "KC", "111", "American", "Brunch", "Casual", "no", "asd"));
        //handler.addNewEvent(new EventModel("SUPREMEPARTY", "Smith", "John", "12/10/17", "11:00am", "2hr", "NH", "200", "Itailian", "dinner", "formal", "no", "Balloons"));

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid(username, password)){

                    DBManager handler = new DBManager(LoginScreenActivity.this);
                    UserModel user = handler.retrieveUser(username.getText().toString(), password.getText().toString());
                    if (user != null) {
                        Intent intent;
                        String bleh = user.getUsertype();
                        if(bleh.compareTo("Caterer") == 0) {
                            intent = new Intent(LoginScreenActivity.this, CatererHomeScreenActivity.class);
                            //Toast.makeText(LoginScreenActivity.this, "Registration CATERER", Toast.LENGTH_LONG).show();
                        }else if (bleh.compareTo("User") == 0) {
                            intent = new Intent(LoginScreenActivity.this, UserHomeScreenActivity.class);
                            //Toast.makeText(LoginScreenActivity.this, "Registration USER", Toast.LENGTH_LONG).show();
                        }else {
                            intent = new Intent(LoginScreenActivity.this, StaffHomeScreenActivity.class);
                            //Toast.makeText(LoginScreenActivity.this, "Registration STAFF", Toast.LENGTH_LONG).show();
                        }
                            intent.putExtra("USER", user);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginScreenActivity.this, "WRONG EMAIL ID OR PASSWORD", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    private boolean isInputValid(EditText emailSection, EditText passSection) {

        boolean status = true;

        if (emailSection.getText().toString().length() < 2) {
            emailSection.setError("Please enter valid email ID");
            status = false;
        }

        if (passSection.getText().toString().length() < 2) {
            passSection.setError("Please enter valid password");
            status = false;
        }

        return status;
    }

    public void RegisterClick(View view) {
        Intent intent = new Intent(LoginScreenActivity.this, RegistrationScreenActivity.class);
        startActivity(intent);
    }
}
