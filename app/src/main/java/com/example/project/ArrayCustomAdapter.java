package com.example.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayCustomAdapter extends ArrayAdapter {
    private final Activity activity;
    private final String[] arrayList;
    private int id;

    public ArrayCustomAdapter(Activity activity, String[] names, int id)
    {
        super(activity, id ,names);
        this.activity = activity;
        this.arrayList = names;
        this.id = id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = convertView;

        if(rowView == null)
        {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(id,parent,false);
        }

        if(id==R.layout.row_user_list)
        {
            TextView nameUser;
            nameUser = rowView.findViewById(R.id.tvUserName);
            nameUser.setText(arrayList[position]);

        }else{
            //se enlazan los componetes del array
            TextView tvsolicitud;
            tvsolicitud = rowView.findViewById(R.id.tvSolicitud);
            //se setean los componentes de dicho array
            String departamento = arrayList[position];
            tvsolicitud.setText(departamento);
        }
        return  rowView;
    }

}
