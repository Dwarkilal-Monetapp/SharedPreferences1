package com.journaldev.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    EditText password;
    EditText mobile;
    public static final String mypreference = "mypref";
    public static final String Name = "name_Key";
    public static final String Email = "email_Key";
    public static final String Mobile = "mobile_Key";
    public static final String Password = "password_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        mobile = (EditText) findViewById(R.id.etMobile);
        password = (EditText) findViewById(R.id.etPassword);
        sharedpreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);

    }



     /*   if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));

        }
        if (sharedpreferences.contains(Mobile)) {
            mobile.setText(sharedpreferences.getString(Mobile, ""));

        }

    }*/
//Here we are storing the user provided data using sharedpreferences

    public void setSharedPreferences(View view) {

        String userName = name.getText().toString();
        String emailID = email.getText().toString();
        String mobileNo = mobile.getText().toString();
        String userPassword= password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String mobilePattern= "\\d{10}";
        if(emailID.matches(emailPattern)){
            editor.putString(Email, emailID);
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            email.setText("");
            /*//or
            EditText.("invalid email");*/
        }
        if(userName.equals("")){
            editor.putString(Name,userName);
        }
        else {
            Toast.makeText(getApplicationContext(),"Please Enter Name", Toast.LENGTH_SHORT).show();
            name.setText("");
        }
        if(mobileNo.matches(mobilePattern)){
            editor.putString(Mobile, mobileNo);
        }
        else {
            Toast.makeText(getApplicationContext(),"Enter valid mobile no", Toast.LENGTH_SHORT).show();
            mobile.setText("");
        }
        if(!userPassword.equals("")){
            editor.putString(Password, userPassword);
        }
        else {
            Toast.makeText(getApplicationContext(),"Please Enter Password", Toast.LENGTH_SHORT).show();
            password.setText("");
        }
        editor.commit();
        //or editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}

  /*  public void Get(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        mobile = (EditText) findViewById(R.id.etMobile);
       password = (EditText) findViewById(R.id.etPassword);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)&&) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Mobile)) {
            email.setText(sharedpreferences.getString(Mobile, ""));

        }
        if (sharedpreferences.contains(Password)) {
            email.setText(sharedpreferences.getString(Password, ""));
        }
    }
*/
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/


