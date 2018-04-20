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

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid(username, password)){

                    DBManager handler = new DBManager(LoginScreenActivity.this);
                    UserModel user = handler.retrieveUser(username.getText().toString(), password.getText().toString());
                    String bleh = user.getUsertype();
                    if (user != null) {
                        Intent intent;
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
