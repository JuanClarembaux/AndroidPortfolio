package com.example.portfolio.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.portfolio.R;

import java.sql.Date;
import java.util.List;

public class ListAdapterRepos extends ArrayAdapter<GithubRepo> {

    private List<GithubRepo> reposList;
    private Context mContext;
    private int resourceLayout;

    public ListAdapterRepos(@NonNull Context context, int resource, List<GithubRepo> objects) {
        super(context, resource, objects);
        this.reposList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        GithubRepo githubRepo = reposList.get(position);

        TextView namedata = view.findViewById(R.id.plm_namedata_tv);
        namedata.setText(githubRepo.getName());
        TextView languagedata = view.findViewById(R.id.plm_languagedata_tv);
        languagedata.setText(githubRepo.getLanguage());
        TextView createdatedata = view.findViewById(R.id.plm_createdatedata_tv);
        createdatedata.setText(String.valueOf(githubRepo.getCreated_at()));
        TextView updatedatedata = view.findViewById(R.id.plm_updatedatedata_tv);
        updatedatedata.setText(String.valueOf(githubRepo.getUpdated_at()));

        return view;
    }
}
