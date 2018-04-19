package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

/**
 * Created by Miguel Gomez on 3/24/2018.
 */

public class RegistrationScreenActivity extends AppCompatActivity {
    Button RegisterBtn;
    UserModel user;
    EditText username, password, firstName, lastName, utaID, phoneNum, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        RegisterBtn = (Button) findViewById(R.id.RegistrationRegisterBtn);
/*
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Registration Successful! ", Toast.LENGTH_LONG).show();
            }
        });
*/
    }


    public void addNewUser(View view) {
        Toast.makeText(getApplicationContext(), "Registration Successful! ", Toast.LENGTH_LONG).show();
        username = (EditText) findViewById(R.id.in_username2);
        password = (EditText) findViewById(R.id.in_password2);
        firstName = (EditText) findViewById(R.id.in_first_name2);
        lastName = (EditText) findViewById(R.id.in_last_name2);
        utaID = (EditText) findViewById(R.id.in_uta_id2);
        phoneNum = (EditText) findViewById(R.id.in_phone_number2);
        email = (EditText) findViewById(R.id.in_email2);

        String Susername = username.getText().toString();
        String Spassword = password.getText().toString();
        String SfirstName = firstName.getText().toString();
        String SlastName = lastName.getText().toString();
        String Semail = email.getText().toString();
        String SutaID = utaID.getText().toString();
        int IutaID = Integer.parseInt(SutaID);
        String SphoneNum = phoneNum.getText().toString();
        int IphoneNum = Integer.parseInt(SphoneNum);
        //RegisterButtonClicked(view);
    }
    /*
    public void RegisterButtonClicked(View view) {

        Intent intent = new Intent(this, ApplicationScreenActivity.class);
        startActivity(intent);
    }
    */
}
