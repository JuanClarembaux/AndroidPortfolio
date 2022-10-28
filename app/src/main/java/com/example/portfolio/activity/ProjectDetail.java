package com.example.portfolio.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolio.R;

public class ProjectDetail extends AppCompatActivity {

    ImageView github_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectdetail);


        TextView projectNameData = findViewById(R.id.ap_projectnameData_tv);
        projectNameData.setText(getIntent().getStringExtra("name"));
        TextView projectDescriptionData = findViewById(R.id.ap_projectDescriptionData_tv);
        projectDescriptionData.setText(getIntent().getStringExtra("description"));
        TextView projectLanguageData = findViewById(R.id.ap_languageData_tv);
        projectLanguageData.setText(getIntent().getStringExtra("language"));
        TextView projectCreatedAtData = findViewById(R.id.ap_createdAtData_tv);
        projectCreatedAtData.setText(getIntent().getStringExtra("created_at"));
        TextView projectUpdatedAtData = findViewById(R.id.ap_updatedAtData_tv);
        projectUpdatedAtData.setText(getIntent().getStringExtra("updated_at"));
        TextView projectPushedAtData = findViewById(R.id.ap_pushedAtData_tv);
        projectPushedAtData.setText(getIntent().getStringExtra("pushed_at"));
        github_img = findViewById(R.id.ap_github_imageView);

        this.findViews();
    }
    private void findViews(){
        github_img.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getIntent().getStringExtra("html_url")));
            startActivity(intent);
        });
    }
}
