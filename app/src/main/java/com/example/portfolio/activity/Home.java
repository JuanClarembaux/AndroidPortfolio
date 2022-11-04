package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.portfolio.R;

public class Home extends AppCompatActivity {

    private Button projects;
    private Button aboutme;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        projects=findViewById(R.id.ah_projects_bt);
        aboutme=findViewById(R.id.ah_aboutme_bt);

        preferences = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

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
            try {
                if(this.preferences.getString("githubUsuario", "").equals("")){
                    Toast.makeText(Home.this, "Usuario de Github no especificado", Toast.LENGTH_LONG).show();
                    return;
                };
                Intent intent = new Intent(getBaseContext(), Project.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(Home.this, "Usuario de Github no especificado", Toast.LENGTH_LONG).show();
                Log.e("ERROR", "onFailure: " + e.getMessage());
            }
        });
        aboutme.setOnClickListener(view ->{
            try {
                Intent intent = new Intent(getBaseContext(), AboutMe.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(Home.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                Log.e("ERROR", "onFailure: " + e.getMessage());
            }
        });
    }

}