package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.portfolio.R;
import com.example.portfolio.model.DBUser;
import com.example.portfolio.model.GithubRepo;
import com.example.portfolio.model.ListAdapterRepos;
import com.example.portfolio.model.ListAdapterUser;
import com.example.portfolio.service.RepoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Project extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView repos;
    ListAdapterRepos mAdapter;
    private Retrofit retrofit;

    private List<GithubRepo> listaRepos;

    private static final String TAG = "GITHUB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        repos = findViewById(R.id.ap_proyectos_lv);

        listaRepos = new ArrayList<GithubRepo>();

        obtenerDatosApi();

        mAdapter = new ListAdapterRepos(this, R.layout.project_listview_model, listaRepos);

        repos.setAdapter(mAdapter);

        repos.setOnItemClickListener(this);

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
        intent.putExtra("name", mAdapter.getItem(position).getName());
        intent.putExtra("description", mAdapter.getItem(position).getDescription());
        intent.putExtra("html_url", mAdapter.getItem(position).getHtml_url());
        intent.putExtra("language", mAdapter.getItem(position).getLanguage());
        intent.putExtra("created_at", mAdapter.getItem(position).getCreated_at());
        intent.putExtra("updated_at", mAdapter.getItem(position).getUpdated_at());
        intent.putExtra("pushed_at", mAdapter.getItem(position).getPushed_at());
        startActivity(intent);
    }

    private void obtenerDatosApi() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepoService repoService = retrofit.create(RepoService.class);
        Call<List<GithubRepo>> reposRespuestaCall = repoService.getRepos("JuanClarembaux");

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
}




/*List<GithubRepo> repositoriosRespuesta = response.body();

                    for (int i = 0; i < repositoriosRespuesta.size(); i++){
                        GithubRepo githubRepo = repositoriosRespuesta.get(i);
                        reposRespuesta.add(githubRepo);
                    }*/

//for(Repo repo : response.body()){