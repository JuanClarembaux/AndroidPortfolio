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
        projectNameData.setText(getIntent().getStringExtra("projectName"));
        TextView projectDescriptionData = findViewById(R.id.ap_projectDescriptionData_tv);
        projectDescriptionData.setText(getIntent().getStringExtra("projectDescription"));
        TextView projectOwnerData = findViewById(R.id.ap_projectOwnerData_tv);
        projectOwnerData.setText(getIntent().getStringExtra("projectOwner"));
        TextView projectCollaboratorsData = findViewById(R.id.ap_projectCollaboratorsData_tv);
        projectCollaboratorsData.setText(getIntent().getStringExtra("projectCollaborators"));
        github_img = findViewById(R.id.ap_github_imageView);

        this.findViews();
    }
    private void findViews(){
        github_img.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getIntent().getStringExtra("projectURL")));
            startActivity(intent);
        });
    }
}
