package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.portfolio.R;
import com.example.portfolio.model.DBUser;
import com.example.portfolio.model.GithubRepo;
import com.example.portfolio.service.RepoService;
import com.example.portfolio.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AboutMe extends AppCompatActivity {

    TextView surname;
    TextView name;
    TextView ocupation;
    ImageView linkedin;
    ImageView gmail;
    ImageView github;

    private Retrofit retrofit;
    DBUser DBUser;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        surname=findViewById(R.id.aam_surnameData_tv);
        name=findViewById(R.id.aam_nameData_tv);
        ocupation=findViewById(R.id.aam_ocupationData_tv);
        linkedin=findViewById(R.id.aam_linkedin_imageView);
        gmail=findViewById(R.id.aam_gmail_imageView);
        github=findViewById(R.id.aam_github_imageView);

        preferences = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        obtenerDatos();

        this.findViews();
    }

    private void obtenerDatos(){
        DBUser DBUserRequest = new DBUser(this.preferences.getString("gmailUsuario", ""), this.preferences.getString("contrasenaUsuario", ""));

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<DBUser> userCall = userService.login(DBUserRequest);

        userCall.enqueue(new Callback<DBUser>() {
            @Override
            public void onResponse(Call<DBUser> call, Response<DBUser> response) {
                if (response.isSuccessful()){
                    DBUser = response.body();

                    surname.setText(DBUser.getApellidoUsuario());
                    name.setText(DBUser.getNombreUsuario());
                    ocupation.setText(DBUser.ocupacionUsuario);
                }
                else{
                    response.errorBody();
                }
            }

            @Override
            public void onFailure(Call<DBUser> call, Throwable t) {
                t.getMessage();
            }
        });
    }

    private void findViews(){
        linkedin.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(DBUser.getLinkedinUsuario()));
            startActivity(intent);
        });
        gmail.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, DBUser.getGmailUsuario());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
        github.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(DBUser.getGithubUsuario()));
            startActivity(intent);
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