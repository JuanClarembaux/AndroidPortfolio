package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button pantallaAcercaDeMi;
    private Button pantallaProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantallaAcercaDeMi=findViewById(R.id.am_acercaDeMi_bt);
        pantallaProyectos=findViewById(R.id.am_proyectos_bt);

        this.findViews();

    }

    private void findViews(){
        pantallaAcercaDeMi.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), AcercaDeMi.class);
            startActivity(intent);
        });
        pantallaProyectos.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Proyectos.class);
            startActivity(intent);
        });
    }

}