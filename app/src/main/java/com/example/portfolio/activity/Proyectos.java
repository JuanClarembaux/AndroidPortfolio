package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.portfolio.Project;
import com.example.portfolio.R;

import java.util.ArrayList;
import java.util.List;

public class Proyectos extends AppCompatActivity {

    private ListView projects_lv;
    private List<Project> projectsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectos);
        projects_lv = findViewById(R.id.ap_proyectos_lv);

        projectsList.add(new Project(1, "AndroidPortfolio", "https://github.com/JuanClarembaux/AndroidPortfolio"));
        projectsList.add(new Project(2, "AndroidCalculatorAndConversor", "https://github.com/JuanClarembaux/AndroidPortfolio"));
        projectsList.add(new Project(3, "WebApplication_Blog", "https://github.com/JuanClarembaux/AndroidCalculatorAndConversor"));
        projectsList.add(new Project(4, "Bootcamp.Backend.C-.NET", "https://github.com/JuanClarembaux/Bootcamp.Backend.C-.NET"));

        ArrayAdapter<Project> projectsAdapter = new ArrayAdapter<Project>(this, android.R.layout.simple_list_item_1, projectsList);
        projects_lv.setAdapter(projectsAdapter);

        projects_lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> projectsAdapter, View view, int position, long id){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(projectsList.get(position).projectURL));
                startActivity(intent);
            }
        });
    }
}