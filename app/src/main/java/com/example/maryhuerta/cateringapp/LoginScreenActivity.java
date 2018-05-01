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
        handler.addNewUser(new UserModel("1001200002", "User2", "Last", "original@gmail.com", "123", "UserTest2", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "User"));
        handler.addNewUser(new UserModel("1001200003", "Caterer", "Last", "original@gmail.com", "123", "CatererTest", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Caterer"));
        handler.addNewUser(new UserModel("1001200004", "Caterer2", "Last", "original@gmail.com", "123", "CatererTest2", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Caterer"));
        handler.addNewUser(new UserModel("1001200005", "Staff-Harry", "Last", "original@gmail.com", "123", "StaffTest", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));
        handler.addNewUser(new UserModel("1001200006", "Staff_John", "Last", "original@gmail.com", "123", "StaffTest2", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));
        handler.addNewUser(new UserModel("1001200007", "Staff_Larry", "Last", "original@gmail.com", "123", "StaffTest3", "555-555-5555", " 99 road", "Mountain View",  "7777", "Cali", "Staff"));


        //Test Events
        handler.addNewEvent(new EventModel("1001200000","NONE","OkParty", "Cam", "Hastings", "12/19/18", "0", "2", "KC", "20", "Chinese",  "Formal", "Breakfast", "no","Beach Ball"));
        handler.addNewEvent(new EventModel("1001200002","NONE","OkParty", "Cam", "Hastings", "12/19/18", "0", "2", "KC", "20", "Chinese",  "Formal", "Breakfast", "no","Beach Ball"));
        handler.addNewEvent(new EventModel("1001200002","1001200003","GreatParty", "Hastings", "Cam", "1/1/18", "12", "3", "Shard", "50", "American", "Informal", "Lunch", "no", "asd"));
        handler.addNewEvent(new EventModel("1001200002", "1001200004","SUPREMEPARTY", "Smith", "John", "12/10/17", "14", "2", "Arlington", "100", "Itailian", "Formal", "Supper", "no", "Balloons"));

        //Assigned Staff
        handler.AddStaffToEvent("1001200005","OkParty" );
        handler.AddStaffToEvent("1001200006","GreatParty" );
        handler.AddStaffToEvent("1001200007","GreatParty" );
        handler.AddStaffToEvent("1001200007","SUPREMEPARTY" );

        //Halls
        handler.addNewHall(new HallModel("KC", "25"));
        handler.addNewHall(new HallModel("Shard", "25"));
        handler.addNewHall(new HallModel("Arlington", "50"));
        handler.addNewHall(new HallModel("Liberty", "75"));
        handler.addNewHall(new HallModel("Maverick", "100"));

        //this.hallName = hallName;
        //this.hallCapacity = hallCapacity;
        //this.hallBuiling = hallBuiling;
        //this.hallFloor = hallFlo

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
                        String info = user.getId() + ";" + user.getUsertype();
                        intent.putExtra("USERINFO", info);
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
