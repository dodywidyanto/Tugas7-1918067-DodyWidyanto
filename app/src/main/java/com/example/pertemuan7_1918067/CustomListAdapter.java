package com.example.pertemuan7_1918067;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Clashofclans> Clashofclans;
    public CustomListAdapter(Activity activity, List<Clashofclans>
            Clashofclans) {
        this.activity = activity;
        this.Clashofclans = Clashofclans;
    }
    @Override
    public int getCount() {
        return Clashofclans.size();
    }
    @Override
    public Object getItem(int location) {
        return Clashofclans.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_username);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_balaikota);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Clashofclans m = Clashofclans.get(position);
        nama.setText("Username : "+ m.get_username());
        kelas.setText("Balai Kota : "+ m.get_balaikota());
        return convertView;
    }
}