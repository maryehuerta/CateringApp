package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__screen);

        Button RegisterBtn = (Button) findViewById(R.id.RegistrationRegisterBtn);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            Bundle bundle=new Bundle();
            @Override
            public void onClick(View view) {
                if(true)//ADD LOGIC TO VERIFY REGISTRATION ON SQL SERVER
                {
//                    bundle.putString("text", "Registration Successful");

                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                   // Intent RegisterBtnIntent= new Intent(".ApplicationScreenActivity").putExtras(bundle);
                    Intent RegisterBtnIntent= new Intent(".ApplicationScreenActivity");
                   // Intent RegisterBtnIntent= new Intent(this, ApplicationScreenActivity.class);
                    startActivity(RegisterBtnIntent);
                }
                else
                {
                    bundle.putString("text", "ERROR: Could Not Register");
                    Toast.makeText(getApplicationContext(), "ERROR: Could Not Register", Toast.LENGTH_LONG).show();
                    //Intent RegisterBtnIntent= new Intent(".ApplicationScreenActivity");
                    //startActivity(RegisterBtnIntent);
                }
            }
        });
    }

    public void onRegisterButtonTap(View v)
    {
        /*

        */

//        if(true)//ADD LOGIC TO VERIFY REGISTRATION ON SQL SERVER
  //      {
 //           Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
    //    }
      //  else
        //{
   //         Toast.makeText(getApplicationContext(), "ERROR: Could Not Register", Toast.LENGTH_LONG).show();
        //}
//        Intent RegisterBtnIntent= new Intent(".ApplicationScreenActivity");
  //      startActivity(RegisterBtnIntent);
    }
}

/*WORKS*/
/*
public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__screen);
    }

    public void onRegisterButtonTap(View v)
    {
        /*Button RegisterBtn = (Button) findViewById(R.id.RegistrationRegisterBtn);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(true)//ADD LOGIC TO VERIFY REGISTRATION ON SQL SERVER
                {
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "ERROR: Could Not Register", Toast.LENGTH_LONG).show();
                }
            }
        });
        */

//        if(true)//ADD LOGIC TO VERIFY REGISTRATION ON SQL SERVER
        //      {
        //           Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
        //    }
        //  else
        //{
        //         Toast.makeText(getApplicationContext(), "ERROR: Could Not Register", Toast.LENGTH_LONG).show();
        //}

/*
        Intent RegisterBtnIntent= new Intent(".ApplicationScreenActivity");
        startActivity(RegisterBtnIntent);
    }
}
*/
/*END OF WORKS*/