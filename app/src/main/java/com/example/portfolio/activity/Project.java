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
import android.widget.Toast;

import com.example.portfolio.R;
import com.example.portfolio.model.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Project extends AppCompatActivity implements AdapterView.OnItemClickListener{

    /*private ListView projects_lv;
    private List<com.example.portfolio.model.Project> projectsList = new ArrayList<>();*/

    private ListView projects;
    private List<com.example.portfolio.model.Project> mListProjects = new ArrayList<>();
    ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        projects = findViewById(R.id.ap_proyectos_lv);
        projects.setOnItemClickListener(this);

        mListProjects.add(new com.example.portfolio.model.Project(1, "AndroidPortfolio", "https://github.com/JuanClarembaux/AndroidPortfolio", "C#", "blabla", "Juan Cruz Clarembaux", "None", "Web"));
        mListProjects.add(new com.example.portfolio.model.Project(2, "AndroidCalculatorAndConversor", "https://github.com/JuanClarembaux/AndroidPortfolio", "C#", "blabla", "Juan Cruz Clarembaux", "None", "Web"));
        mListProjects.add(new com.example.portfolio.model.Project(3, "WebApplication_Blog", "https://github.com/JuanClarembaux/AndroidCalculatorAndConversor", "C#", "blabla", "Juan Cruz Clarembaux", "None", "Web"));
        mListProjects.add(new com.example.portfolio.model.Project(4, "Bootcamp.Backend.C-.NET", "https://github.com/JuanClarembaux/Bootcamp.Backend.C-.NET", "C#", "blabla", "Juan Cruz Clarembaux", "None", "Web"));
        mListProjects.add(new com.example.portfolio.model.Project(5, "WebApplication_Blog", "https://github.com/JuanClarembaux/AndroidCalculatorAndConversor", "C#", "blabla", "Juan Cruz Clarembaux", "None", "Web"));

        mAdapter = new ListAdapter(this, R.layout.project_listview_model, mListProjects);

        projects.setAdapter(mAdapter);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, ProjectDetail.class);
        intent.putExtra("projectName", mAdapter.getItem(position).getProjectName());
        //intent.putExtra("projectLanguage", mAdapter.getItem(position).getProjectLanguage());
        intent.putExtra("projectDescription", mAdapter.getItem(position).getProjectDescription());
        intent.putExtra("projectOwner", mAdapter.getItem(position).getProjectOwner());
        intent.putExtra("projectCollaborators", mAdapter.getItem(position).getProjectCollaborators());
        //intent.putExtra("projectType", mAdapter.getItem(position).getProjectType());
        intent.putExtra("projectURL", mAdapter.getItem(position).getProjectURL());
        startActivity(intent);
    }
}