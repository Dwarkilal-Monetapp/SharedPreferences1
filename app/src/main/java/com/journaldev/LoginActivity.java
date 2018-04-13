package com.journaldev.sharedpreferences;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.journaldev.sharedpreferences.MainActivity;
import com.journaldev.sharedpreferences.R;

public class LoginActivity extends Activity {
    SharedPreferences log_Pref;
    EditText mobile, pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobile = (EditText) findViewById(R.id.etmobile);
        pass = (EditText) findViewById(R.id.etpassword);
        log_Pref = getSharedPreferences("Registration", 0);
        getPreferences();
    }

    // retrieving value from Registration
    public void getPreferences() {
        String login_email = log_Pref.getString("Email", null);
        String login_password = log_Pref.getString("Password", null);

        // Now check these with previous registered userdata
        if (mobile.getText().equals(mobile) && pass.getText().equals(login_password)) {
            //Send to next Activity

        } else {
            //Login failed send to registration
            Toast.makeText(getApplicationContext(),"User not found,Please check again", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void newRegister() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
