package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portfolio.R;
import com.example.portfolio.model.DBUser;
import com.example.portfolio.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText userET;
    private EditText passwordET;
    private Retrofit retrofit;

    private static final String TAG = "DATABASE";

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.al_login_bt);
        registerButton=findViewById(R.id.al_register_bt);
        userET=findViewById(R.id.al_insertUsername_et);
        passwordET=findViewById(R.id.al_insertPassword_et);

        preferences = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        this.findViews();
    }

    private void obtenerDatos(){
        DBUser DBUserRequest = new DBUser(userET.getText().toString(), passwordET.getText().toString());

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<DBUser> usuarioCall = userService.login(DBUserRequest);

        usuarioCall.enqueue(new Callback<DBUser>() {
            @Override
            public void onResponse(Call<DBUser> call, Response<DBUser> response) {
                if (response.isSuccessful()){

                    preferencesEditor.putInt("idUsuario", response.body().getIdUsuario());
                    preferencesEditor.putString("nombreUsuario", response.body().getNombreUsuario());
                    preferencesEditor.putString("apellidoUsuario", response.body().getApellidoUsuario());
                    preferencesEditor.putString("ocupacionUsuario", response.body().getOcupacionUsuario());
                    preferencesEditor.putString("gmailUsuario", response.body().getGmailUsuario());
                    preferencesEditor.putString("linkedinUsuario", response.body().getLinkedinUsuario());
                    preferencesEditor.putString("githubUsuario", response.body().getGithubUsuario());
                    preferencesEditor.putString("contrasenaUsuario", response.body().getContrasenaUsuario());
                    preferencesEditor.commit();

                    Intent intent = new Intent(getBaseContext(), Home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DBUser> call, Throwable t) {
                Log.e(TAG, "  onFailure: " + t.getMessage());
            }
        });
    }

    private void findViews(){
        loginButton.setOnClickListener(view ->{
            obtenerDatos();
        });
        registerButton.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Register.class);
            startActivity(intent);
        });
    }
}