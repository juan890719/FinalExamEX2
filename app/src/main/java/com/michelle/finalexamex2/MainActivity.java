package com.michelle.finalexamex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_email;
    private EditText ed_password;
    private ImageView face;
    private Switch sw;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_email = findViewById(R.id.email);
        ed_password = findViewById(R.id.password);
        sw = findViewById(R.id.sw);
        face = findViewById(R.id.face);
        face.setAlpha(1.0f);
        face.setVisibility(View.VISIBLE);
        face.animate().alpha(0.0f).setDuration(5500);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView textView = findViewById(R.id.textView);
                textView.setText(isNext ? "註冊畫面" : "請輸入帳號密碼");
            }
        });
    }
    public void login (View view){
        String emailString = ed_email.getText().toString();
        String passwordString = ed_password.getText().toString();
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        pref.edit()
                .putString("EMAIL",emailString)
                .putString("PASSWORD",passwordString)
                .commit();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
