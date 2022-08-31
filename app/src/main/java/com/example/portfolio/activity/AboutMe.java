package com.example.portfolio.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.portfolio.R;
import com.example.portfolio.model.User;

public class AboutMe extends AppCompatActivity {

    TextView fullname;
    TextView ocupation;
    ImageView linkedin;
    ImageView gmail;
    ImageView github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        fullname=findViewById(R.id.aam_fullnameData_tv);
        ocupation=findViewById(R.id.aam_ocupationData_tv);
        linkedin=findViewById(R.id.aam_linkedin_imageView);
        gmail=findViewById(R.id.aam_gmail_imageView);
        github=findViewById(R.id.aam_github_imageView);

        this.findViews();
    }

    private void findViews(){
        linkedin.setOnClickListener(view ->{
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/juan-cruz-clarembaux-79a345215/"));
                startActivity(intent);
        });
        gmail.setOnClickListener(view ->{
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "juanclarembaux12@gmail.com");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
        });
        github.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/JuanClarembaux"));
            startActivity(intent);
        });
        fullname.setText("Juan Cruz Clarembaux");
        ocupation.setText("Developer");
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