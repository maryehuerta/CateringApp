package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Toast;

//import java.util.Vector;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class RegistrationScreenActivity extends AppCompatActivity {
    Button RegisterBtn;
    EditText username, password, firstName, lastName, utaID, phoneNum, email, streetAddress, city, zipcode, state;
    RadioGroup usertype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        RegisterBtn = (Button) findViewById(R.id.RegistrationRegisterBtn);
        username = (EditText) findViewById(R.id.in_username2);
        password = (EditText) findViewById(R.id.in_password2);
        firstName = (EditText) findViewById(R.id.in_first_name2);
        lastName = (EditText) findViewById(R.id.in_last_name2);
        utaID = (EditText) findViewById(R.id.in_uta_id2);
        phoneNum = (EditText) findViewById(R.id.in_phone_number2);
        email = (EditText) findViewById(R.id.in_email2);
        streetAddress = (EditText) findViewById(R.id.in_street_address2);
        city = (EditText) findViewById(R.id.in_city2);
        zipcode = (EditText) findViewById(R.id.in_zip_code2);
        state = (EditText) findViewById(R.id.in_state2);
        usertype = (RadioGroup) findViewById(R.id.radioGroup1);
        RegisterBtn = (Button) findViewById(R.id.RegistrationRegisterBtn);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = new UserModel();
                user.setUserFName(firstName.getText().toString());
                user.setUserLName(lastName.getText().toString());
                user.setUserEmail(email.getText().toString());
                user.setUserPassword(password.getText().toString());
                user.setUsername(username.getText().toString());
                user.setId(utaID.getText().toString());
                user.setPhoneNum(phoneNum.getText().toString());
                user.setStreetAddress(streetAddress.getText().toString());
                user.setCity(city.getText().toString());
                user.setState(zipcode.getText().toString());
                user.setZipcode(zipcode.getText().toString());

                int bleh = usertype.getCheckedRadioButtonId();
                switch(bleh)
                {
                    case R.id.radioButton7:
                        user.setUsertype("User");
                        break;
                    case R.id.radioButton9:
                        user.setUsertype("Caterer");
                        break;
                    case R.id.radioButton8:
                        user.setUsertype("Staff");
                        break;
                }
                DBManager handler = new DBManager(RegistrationScreenActivity.this);
                handler.addNewUser(user);
                Toast.makeText(RegistrationScreenActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegistrationScreenActivity.this, LoginScreenActivity.class);
                startActivity(intent);

            }
        });
    }


}
