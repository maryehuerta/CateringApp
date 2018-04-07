package com.example.maryhuerta.cateringapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserRequestedEventDetails extends AppCompatActivity {

    // https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    // TODO: return results/actions to be taken to parent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_requested_event_details);

        Bundle data = getIntent().getExtras();
        UserRequestedEventItem item = (UserRequestedEventItem) data.getParcelable(UserRequestedEventList.ITEM);
        if (item != null){
            Log.d("LOL", item.getFirstName());
            TextView textView = findViewById(R.id.textView26);
            textView.setText(item.getFirstName());
        }
    }
}
