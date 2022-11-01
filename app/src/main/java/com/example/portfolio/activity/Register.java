package com.example.portfolio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolio.R;
import com.example.portfolio.model.DBUser;
import com.example.portfolio.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    private EditText surname_ET;
    private EditText name_ET;
    private EditText ocupation_ET;
    private EditText linkedin_ET;
    private EditText gmail_ET;
    private EditText github_ET;
    private EditText password_ET;
    private Button confirmButton;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        surname_ET = findViewById(R.id.ar_insertSurname_et);
        name_ET = findViewById(R.id.ar_insertName_et);
        ocupation_ET = findViewById(R.id.ar_insertOcupation_et);
        linkedin_ET = findViewById(R.id.ar_insertLinkedIn_et);
        gmail_ET = findViewById(R.id.ar_insertGmail_et);
        github_ET = findViewById(R.id.ar_insertGithub_et);
        password_ET = findViewById(R.id.ar_insertPassword_et);
        confirmButton = findViewById(R.id.ar_confirm_bt);

        findViews();
    }

    private void findViews(){
        confirmButton.setOnClickListener(view -> {

            DBUser DBUserRequest = new DBUser(name_ET.getText().toString(), surname_ET.getText().toString(), ocupation_ET.getText().toString(),
                    gmail_ET.getText().toString(), linkedin_ET.getText().toString(), github_ET.getText().toString(), password_ET.getText().toString());

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserService userService = retrofit.create(UserService.class);
            Call<DBUser> userCall = userService.createUser(DBUserRequest);

            userCall.enqueue(new Callback<DBUser>() {
                @Override
                public void onResponse(Call<DBUser> call, Response<DBUser> response) {
                    Toast.makeText(Register.this, "Usuario registrado", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getBaseContext(), Login.class);
                    startActivity(intent);
                }
                @Override
                public void onFailure(Call<DBUser> call, Throwable t) {
                    Toast.makeText(Register.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
