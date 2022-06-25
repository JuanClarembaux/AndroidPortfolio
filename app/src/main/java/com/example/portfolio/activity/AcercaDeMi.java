package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.portfolio.R;
import com.example.portfolio.User;

public class AcercaDeMi extends AppCompatActivity {   

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView visitorUsername;
        TextView userName;
        TextView userMail;
        TextView userPhone;
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de_mi);

        visitorUsername=findViewById(R.id.acd_nombre_tv);
        userName=findViewById(R.id.acd_userName_tv);
        userMail=findViewById(R.id.acd_userMail_tv);
        userPhone=findViewById(R.id.acd_userPhone_tv);

        Bundle extras = getIntent().getExtras();
        String param_texto = extras.getString("USERNAME");
        visitorUsername.setText(param_texto);

        User user = new User(1, "Juan Cruz Clarembaux", "juanclarembaux12@gmail.com", 15409806);
        userName.setText(user.userName);
        userMail.setText(user.userMail);
        userPhone.setText(String.valueOf(user.userPhone));

        userMail.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, user.userMail);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        userPhone.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + user.userPhone));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }
}