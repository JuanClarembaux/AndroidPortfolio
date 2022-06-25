package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.portfolio.R;

public class MainActivity extends AppCompatActivity {

    private Button pantallaAcercaDeMi;
    private Button pantallaProyectos;
    private EditText ingreseNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantallaAcercaDeMi=findViewById(R.id.am_acercaDeMi_bt);
        pantallaProyectos=findViewById(R.id.am_proyectos_bt);
        ingreseNombre=findViewById(R.id.am_ingrese_nombre_et);

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
            case R.id.menu_settings:
                Intent intent = new Intent(getBaseContext(), AcercaDeMi.class);
                startActivity(intent);
            case R.id.menu_exit:
                Intent i = new Intent(getBaseContext(), Proyectos.class);
                startActivity(i);
        }
        return true;
    }

    private void findViews(){
        pantallaAcercaDeMi.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), AcercaDeMi.class);
            intent.putExtra("USERNAME", ingreseNombre.getText().toString());
            startActivity(intent);
        });
        pantallaProyectos.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Proyectos.class);
            startActivity(intent);
        });
    }

}