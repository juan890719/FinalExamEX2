package com.michelle.finalexamex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText ed_eamil;
    private EditText ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_eamil = findViewById(R.id.email);
        ed_password = findViewById(R.id.password);
        String email = getSharedPreferences("data",MODE_PRIVATE)
                .getString("EMAIL"," ");
        ed_eamil.setText(email);
        String password = getSharedPreferences("data",MODE_PRIVATE)
                .getString("PASSWORD"," ");
        ed_password.setText(password);
    }
}
