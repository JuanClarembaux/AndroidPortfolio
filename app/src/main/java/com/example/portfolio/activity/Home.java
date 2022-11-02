package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.portfolio.R;

public class Home extends AppCompatActivity {

    private Button projects;
    private Button aboutme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        projects=findViewById(R.id.ah_projects_bt);
        aboutme=findViewById(R.id.ah_aboutme_bt);

        this.findViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_profile:
                //Toast.makeText(Home.this, "perfil", Toast.LENGTH_LONG);
                Intent intent = new Intent(getBaseContext(), ProfileEdit.class);
                startActivity(intent);
                break;
            case R.id.menu_exit:
                //Toast.makeText(this, "exit", Toast.LENGTH_LONG);
                Intent i = new Intent(getBaseContext(), Login.class);
                startActivity(i);
                break;
        }
        return true;
    }

    private void findViews(){
        projects.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Project.class);
            startActivity(intent);
        });
        aboutme.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), AboutMe.class);
            startActivity(intent);
        });
    }

}