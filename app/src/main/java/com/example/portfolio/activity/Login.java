package com.example.portfolio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portfolio.R;
import com.example.portfolio.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Login extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText userET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.al_login_bt);
        registerButton=findViewById(R.id.al_register_bt);
        userET=findViewById(R.id.al_insertUsername_et);
        passwordET=findViewById(R.id.al_insertPassword_et);

        this.findViews();
    }

    private void findViews(){
        loginButton.setOnClickListener(view ->{
            User user = new User(1, "Juan", "juanclarembaux12@gmail.com", "1234", "2954409806");
            if(Objects.equals(user.userName, userET.getText().toString()) && Objects.equals(user.password, passwordET.getText().toString()))
            {
                //userVerification();
                Intent intent = new Intent(getBaseContext(), Home.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
            }
        });
        registerButton.setOnClickListener(view ->{
            Intent intent = new Intent(getBaseContext(), Register.class);
            startActivity(intent);
        });
    }

    public Connection DBConnection(){
        Connection conn = null;
        try
        {
            StrictMode.ThreadPolicy politic = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politic);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:44367/pIIWeb;domain=Usuario");
            //jdbc:jtds:sqlserver://192.168.0.3;databaseName=pIIWeb;server=DESKTOP-8OMNJR4//SQLEXPRESS;
            //jdbc:sqlserver://localhost:1433;databaseName=pIIWeb;integratedSecurity=true
            //jdbc:jtds:sqlserver://localhost:9876/pIIWeb;domain=company
            //44367
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conn;
    }

    public void userVerification(){
        try
        {
            Statement stm = DBConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Usuario WHERE Usuario.nombreUsuario = " + userET.getText().toString() + " AND Usuario.passwordUsuario = " + passwordET.getText().toString());
            if(rs.next()){
                Intent intent = new Intent(getBaseContext(), Home.class);
                startActivity(intent);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}