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

        String[] partesCreated_at = getIntent().getStringExtra("created_at").split("T");
        String[] partesHoraCreated_at = partesCreated_at[1].split(":");

        String[] partesUpdated_at = getIntent().getStringExtra("updated_at").split("T");
        String[] partesHoraUpdated_at = partesUpdated_at[1].split(":");

        String[] partesPushed_at = getIntent().getStringExtra("pushed_at").split("T");
        String[] partesHoraPushed_at = partesPushed_at[1].split(":");

        TextView projectNameData = findViewById(R.id.ap_projectnameData_tv);
        projectNameData.setText(getIntent().getStringExtra("name"));
        TextView projectDescriptionData = findViewById(R.id.ap_projectDescriptionData_tv);
        projectDescriptionData.setText(getIntent().getStringExtra("description"));
        TextView projectLanguageData = findViewById(R.id.ap_languageData_tv);
        projectLanguageData.setText(getIntent().getStringExtra("language"));
        TextView projectCreatedAtData = findViewById(R.id.ap_createdAtData_tv);
        projectCreatedAtData.setText(partesCreated_at[0] + "  " + partesHoraCreated_at[0] + ":" + partesHoraCreated_at[1]);
        TextView projectUpdatedAtData = findViewById(R.id.ap_updatedAtData_tv);
        projectUpdatedAtData.setText(partesUpdated_at[0] + "  " + partesHoraUpdated_at[0] + ":" + partesHoraUpdated_at[1]);
        TextView projectPushedAtData = findViewById(R.id.ap_pushedAtData_tv);
        projectPushedAtData.setText(partesPushed_at[0] + "  " + partesHoraPushed_at[0] + ":" + partesHoraPushed_at[1]);
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
