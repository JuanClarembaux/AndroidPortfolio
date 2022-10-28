package com.example.portfolio.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.portfolio.R;

import java.sql.Date;
import java.util.List;

public class ListAdapterUser extends ArrayAdapter<DBUser> {

    private List<DBUser> DBUserList;
    private Context mContext;
    private int resourceLayout;
    private long fechaactual = System.currentTimeMillis();
    private Date date = new Date(fechaactual);

    public ListAdapterUser(@NonNull Context context, int resource, List<DBUser> objects) {
        super(context, resource, objects);
        this.DBUserList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        DBUser DBUser = DBUserList.get(position);

        TextView namedata = view.findViewById(R.id.plm_namedata_tv);
        namedata.setText(DBUser.getApellidoUsuario());
        TextView languagedata = view.findViewById(R.id.plm_languagedata_tv);
        languagedata.setText(DBUser.getNombreUsuario());
        TextView loaddatedata = view.findViewById(R.id.ap_createdAtData_tv);
        loaddatedata.setText(String.valueOf(date));

        return view;
    }
}
