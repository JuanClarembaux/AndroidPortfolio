package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.portfolio.R;

public class Login extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText userET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.al_login_bt);
        registerButton=findViewById(R.id.al_register_bt);
        userET=findViewById(R.id.al_insertUsername_et);
        passwordET=findViewById(R.id.al_insertPassword_et);

        this.findViews();
    }

    private void findViews(){
        loginButton.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Home.class);
            startActivity(intent);
        });
        registerButton.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Register.class);
            startActivity(intent);
        });
    }
}