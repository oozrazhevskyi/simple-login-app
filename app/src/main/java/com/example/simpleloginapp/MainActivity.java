package com.example.simpleloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER_EMAIL = "com.example.simpleloginapp.USER_EMAIL";
    public static final String EXTRA_USER_FULLNAME = "com.example.simpleloginapp.USER_FULLNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doLogin(View view) {
        // Get form edits
        EditText editEmail = (EditText) findViewById(R.id.editLoginEmail);
        EditText editPassword = (EditText) findViewById(R.id.editLoginPassword);

        // Get email and password from edits
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        // Get correct credentials from resources of app
        String correctEmail = getResources().getString(R.string.correct_email);
        String correctPassword = getResources().getString(R.string.correct_password);



        // Handle form
        //getResources().getString(R.string.mystring);
        /*
            <string name="correct_email">test@i.ua</string>
            <string name="correct_password">testpass</string>
        */

        if (email.equals(correctEmail) && password.equals(correctPassword)) {
            Intent intent = new Intent(this, UserProfileActivity.class);
            intent.putExtra(EXTRA_USER_FULLNAME, "Олександр");
            startActivity(intent);
        } else {
            Toast.makeText(this, "Wrong email or password", Toast.LENGTH_LONG).show();
        }

        editPassword.setText("");
    }
}