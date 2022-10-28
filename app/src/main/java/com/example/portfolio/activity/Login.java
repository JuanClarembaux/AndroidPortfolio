package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.al_login_bt);
        registerButton=findViewById(R.id.al_register_bt);
        userET=findViewById(R.id.al_insertUsername_et);
        passwordET=findViewById(R.id.al_insertPassword_et);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();


        this.findViews();

    }


    private void obtenerDatos(){
        UserService userService = retrofit.create(UserService.class);
        Call<DBUser> usuarioCall = userService.getUserById(3);

        usuarioCall.enqueue(new Callback<DBUser>() {
            @Override
            public void onResponse(Call<DBUser> call, Response<DBUser> response) {
                if (response.isSuccessful()){
                    DBUser DBUser = response.body();

                    Log.i(TAG, "  DBUser: " + DBUser.getNombreUsuario());
                }
                else{
                    Log.e(TAG, "  onResponse: " + response.errorBody());
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

            // ACA IRIA LA FUNCION QUE BUSCA EL USUARIO POR MAIL EN LA DB Y DEVUELVE SI EXISTE Y EL PASSWORD ES CORRECTO

            //if(Objects.equals(usuario.nombreUsuario, userET.getText().toString()) && Objects.equals(usuario.contrasenaUsuario, passwordET.getText().toString()))
            if(userET != null && passwordET != null)
            {
                Intent intent = new Intent(getBaseContext(), Home.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "DBUser incorrecto", Toast.LENGTH_LONG).show();
            }
        });
        registerButton.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Register.class);
            startActivity(intent);
        });
    }
}