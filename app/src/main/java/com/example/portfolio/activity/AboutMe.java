package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.portfolio.R;
import com.example.portfolio.model.User;

public class AboutMe extends AppCompatActivity {

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView visitorUsername;
        TextView userName;
        TextView userMail;
        TextView userPhone;
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        /*visitorUsername=findViewById(R.id.acd_nombre_tv);
        userName=findViewById(R.id.acd_userName_tv);
        userMail=findViewById(R.id.acd_userMail_tv);
        userPhone=findViewById(R.id.acd_userPhone_tv);*/

        Bundle extras = getIntent().getExtras();
        String param_texto = extras.getString("USERNAME");
        //visitorUsername.setText(param_texto);

        //registerForContextMenu(visitorUsername);

        User user = new User(1, "Juan Cruz Clarembaux", "juanclarembaux12@gmail.com", 15409806);
        //userName.setText(user.userName);
        //userMail.setText(user.userMail);
        //userPhone.setText(String.valueOf(user.userPhone));

        /*userMail.setOnClickListener(view -> {
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
        });*/
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
        int numero = item.getItemId();
        switch(numero){
            case R.id.menu_context_back:
                Intent intent = new Intent(getBaseContext(), Home.class);
                startActivity(intent);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}