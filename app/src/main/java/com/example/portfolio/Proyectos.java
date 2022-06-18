package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Proyectos extends AppCompatActivity {

    private EditText ingreseProyecto_et;
    private Button añadir_bt;
    private ListView proyectos_lv;
    private List<String> proyectosLista = new ArrayList<>();
    private ArrayAdapter<String> proyectosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);

        ingreseProyecto_et = findViewById(R.id.ap_ingreseProyecto_et);
        añadir_bt = findViewById(R.id.ap_añadir_bt);
        proyectos_lv = findViewById(R.id.ap_proyectos_lv);

        proyectosLista.add("Juan");
        proyectosLista.add("Pepe");
        proyectosLista.add("Jose");
        proyectosLista.add("Carlos");

        añadir_bt.setOnClickListener(view -> {
            switch(view.getId()) {
                case R.id.ap_añadir_bt:String texto = ingreseProyecto_et.getText().toString().trim();
                proyectosLista.add(texto);
                proyectosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, proyectosLista);
                proyectos_lv.setAdapter(proyectosAdapter);
            }
        });
        proyectos_lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> proyectosAdapter, View view, int position, long id){
                Toast.makeText(Proyectos.this, "Has pulsado:" + proyectosLista.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}