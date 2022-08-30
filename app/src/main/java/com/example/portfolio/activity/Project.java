package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.portfolio.R;

import java.util.ArrayList;
import java.util.List;

public class Project extends AppCompatActivity {

    private ListView projects_lv;
    private List<com.example.portfolio.model.Project> projectsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        projects_lv = findViewById(R.id.ap_proyectos_lv);

        projectsList.add(new com.example.portfolio.model.Project(1, "AndroidPortfolio", "https://github.com/JuanClarembaux/AndroidPortfolio"));
        projectsList.add(new com.example.portfolio.model.Project(2, "AndroidCalculatorAndConversor", "https://github.com/JuanClarembaux/AndroidPortfolio"));
        projectsList.add(new com.example.portfolio.model.Project(3, "WebApplication_Blog", "https://github.com/JuanClarembaux/AndroidCalculatorAndConversor"));
        projectsList.add(new com.example.portfolio.model.Project(4, "Bootcamp.Backend.C-.NET", "https://github.com/JuanClarembaux/Bootcamp.Backend.C-.NET"));

        ArrayAdapter<com.example.portfolio.model.Project> projectsAdapter = new ArrayAdapter<com.example.portfolio.model.Project>(this, android.R.layout.simple_list_item_1, projectsList);
        projects_lv.setAdapter(projectsAdapter);
        registerForContextMenu(projects_lv);

        projects_lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> projectsAdapter, View view, int position, long id){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(projectsList.get(position).projectURL));
                startActivity(intent);
            }
        });
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