package com.example.portfolio.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.activity.ProjectDetail;

import java.util.ArrayList;
import java.util.Objects;

public class ListAdapterRepos extends RecyclerView.Adapter<ListAdapterRepos.ViewHolder> {

    private ArrayList<GithubRepo> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapterRepos.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(GithubRepo item);
    }

    public ListAdapterRepos(ArrayList<GithubRepo> itemList, Context context, ListAdapterRepos.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ListAdapterRepos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapterRepos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterRepos.ViewHolder holder, final int position) {
        holder.binData(mData.get(position));
    }

    public void setItems(ArrayList<GithubRepo> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView le_language_iv;
        TextView repoName, repoCreated, nameUpdated, nameVisibility;

        ViewHolder(View itemView) {
            super(itemView);

            le_language_iv = itemView.findViewById(R.id.le_language_iv);
            repoName = itemView.findViewById(R.id.le_repoName_tv);
            repoCreated = itemView.findViewById(R.id.le_repoCreated_tv);
            nameUpdated = itemView.findViewById(R.id.le_repoUpdated_tv);
            nameVisibility = itemView.findViewById(R.id.le_repoVisibility_tv);
        }

        void binData(final GithubRepo item) {
            String[] partesCreated_at = item.getCreated_at().split("T");
            String[] partesHoraCreated_at = partesCreated_at[1].split(":");

            String[] partesUpdated_at = item.getUpdated_at().split("T");
            String[] partesHoraUpdated_at = partesUpdated_at[1].split(":");

            if (Objects.equals(item.getLanguage(), "C#"))
                le_language_iv.setImageResource(R.drawable.c_sharp_svgrepo_com);
            if (Objects.equals(item.getLanguage(), "Java"))
                le_language_iv.setImageResource(R.drawable.java_svgrepo_com);
            if (Objects.equals(item.getLanguage(), "Python"))
                le_language_iv.setImageResource(R.drawable.python_svgrepo_com);
            if (Objects.equals(item.getLanguage(), "JavaScript"))
                le_language_iv.setImageResource(R.drawable.js_svgrepo_com);
            if (Objects.equals(item.getLanguage(), "TypeScript"))
                le_language_iv.setImageResource(R.drawable.typescript_svgrepo_com);

            repoName.setText(item.getName());
            repoCreated.setText("Creado:           " + partesCreated_at[0] + "  " + partesHoraCreated_at[0] + ":" + partesHoraCreated_at[1]);
            nameUpdated.setText("Modificado:    " + partesUpdated_at[0] + "  " + partesHoraUpdated_at[0] + ":" + partesHoraUpdated_at[1]);
            if (Objects.equals(item.getVisibility(), "public")) nameVisibility.setText("Public");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}