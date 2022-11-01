package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.portfolio.R;
import com.example.portfolio.model.GithubRepo;
import com.example.portfolio.model.ListAdapterRepos;
import com.example.portfolio.service.RepoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Project extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private Retrofit retrofit;

    private ListAdapterRepos mAdapter;
    private List<GithubRepo> listaRepos;

    private static final String TAG = "GITHUB";

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        preferences = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        init();
    }

    public void init(){
        listaRepos = new ArrayList<>();

        obtenerDatosApi();

        mAdapter = new ListAdapterRepos((ArrayList<GithubRepo>) listaRepos, this);

        RecyclerView recyclerView = findViewById(R.id.alr_list_rv);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);
    }

    private void obtenerDatosApi() {
        String usuarioGithub = this.preferences.getString("githubUsuario", "");
        String[] partesUsuarioGithub = usuarioGithub.split("/");
        String nombreUsuarioGithub = partesUsuarioGithub[3];

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepoService repoService = retrofit.create(RepoService.class);
        Call<List<GithubRepo>> reposRespuestaCall = repoService.getRepos(nombreUsuarioGithub);

        reposRespuestaCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                if (response.isSuccessful()) {
                    for (GithubRepo githubRepo : response.body()) {
                        listaRepos.add(githubRepo);
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "  onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Log.e(TAG, "  onFailure: " + t.getMessage());
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, ProjectDetail.class);
        /*intent.putExtra("name", mAdapter.getItem(position).getName());
        intent.putExtra("description", mAdapter.getItem(position).getDescription());
        intent.putExtra("html_url", mAdapter.getItem(position).getHtml_url());
        intent.putExtra("language", mAdapter.getItem(position).getLanguage());
        intent.putExtra("created_at", mAdapter.getItem(position).getCreated_at());
        intent.putExtra("updated_at", mAdapter.getItem(position).getUpdated_at());
        intent.putExtra("pushed_at", mAdapter.getItem(position).getPushed_at());*/
        startActivity(intent);
    }
}