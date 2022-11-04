package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class ProfileEdit extends AppCompatActivity {

    private EditText surname_ET;
    private EditText name_ET;
    private EditText ocupation_ET;
    private EditText linkedin_ET;
    private EditText gmail_ET;
    private EditText github_ET;
    private EditText password_ET;
    private Button confirmButton;

    private Retrofit retrofit;

    SharedPreferences preferences;
    SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        surname_ET = findViewById(R.id.ape_insertSurname_et);
        name_ET = findViewById(R.id.ape_insertName_et);
        ocupation_ET = findViewById(R.id.ape_insertOcupation_et);
        linkedin_ET = findViewById(R.id.ape_insertLinkedIn_et);
        gmail_ET = findViewById(R.id.ape_insertGmail_et);
        github_ET = findViewById(R.id.ape_insertGithub_et);
        password_ET = findViewById(R.id.ape_insertPassword_et);
        confirmButton = findViewById(R.id.ape_confirm_bt);

        preferences = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        insertarDatosExistentes();

        findViews();
    }

    private void findViews(){
        confirmButton.setOnClickListener(view -> {
            if(name_ET.getText().toString().equals("") || surname_ET.getText().toString().equals("") || gmail_ET.getText().toString().equals("")
                    || github_ET.getText().toString().equals("") || password_ET.getText().toString().equals("")){
                Toast.makeText(ProfileEdit.this, "Complete los campos obligatorios ( * )", Toast.LENGTH_LONG).show();
                return;
            }

            DBUser DBUserRequest = new DBUser(name_ET.getText().toString(), surname_ET.getText().toString(), ocupation_ET.getText().toString(),
                    gmail_ET.getText().toString(), linkedin_ET.getText().toString(), github_ET.getText().toString(), password_ET.getText().toString());

            retrofit = new Retrofit.Builder()
                    //.baseUrl("http://10.0.2.2:3000")
                    .baseUrl("https://nodejsapigithub-production.up.railway.app")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserService userService = retrofit.create(UserService.class);
            Call<DBUser> userCall = userService.editUserById(this.preferences.getInt("idUsuario", 0), DBUserRequest);

            userCall.enqueue(new Callback<DBUser>() {
                @Override
                public void onResponse(Call<DBUser> call, Response<DBUser> response) {
                    Toast.makeText(ProfileEdit.this, "Usuario editado", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), Home.class);
                    startActivity(intent);
                }
                @Override
                public void onFailure(Call<DBUser> call, Throwable t) {
                    Toast.makeText(ProfileEdit.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    public void insertarDatosExistentes(){
        surname_ET.setText(this.preferences.getString("apellidoUsuario", "" ));
        name_ET.setText(this.preferences.getString("nombreUsuario", "" ));
        ocupation_ET.setText(this.preferences.getString("ocupacionUsuario", "" ));
        linkedin_ET.setText(this.preferences.getString("linkedinUsuario", "" ));
        gmail_ET.setText(this.preferences.getString("gmailUsuario", "" ));
        github_ET.setText(this.preferences.getString("githubUsuario", "" ));
        password_ET.setText(this.preferences.getString("contrasenaUsuario", "" ));
    }
}