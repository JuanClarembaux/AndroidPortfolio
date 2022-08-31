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

public class ListAdapter extends ArrayAdapter<Project> {

    private List<Project> projectList;
    private Context mContext;
    private int resourceLayout;
    private long fechaactual = System.currentTimeMillis();
    private Date date = new Date(fechaactual);

    public ListAdapter(@NonNull Context context, int resource, List<Project> objects) {
        super(context, resource, objects);
        this.projectList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        Project project = projectList.get(position);

        TextView namedata = view.findViewById(R.id.plm_namedata_tv);
        namedata.setText(project.getProjectName());
        TextView languagedata = view.findViewById(R.id.plm_languagedata_tv);
        languagedata.setText(project.getProjectLanguage());
        TextView loaddatedata = view.findViewById(R.id.plm_loaddatedata_tv);
        loaddatedata.setText(String.valueOf(date));

        return view;
    }
}
