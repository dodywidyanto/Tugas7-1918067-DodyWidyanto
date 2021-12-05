package com.example.pertemuan7_1918067;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Clashofclans> listClashofclans = new
            ArrayList<Clashofclans>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listClashofclans
        );
        mListView = (ListView) findViewById(R.id.list_clashofclans);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listClashofclans.clear();
        List<Clashofclans> clashofclans = db.ReadMahasiswa();
        for (Clashofclans coc : clashofclans) {
            Clashofclans daftar = new Clashofclans();
            daftar.set_id(coc.get_id());
            daftar.set_username(coc.get_username());
            daftar.set_balaikota(coc.get_balaikota());
            listClashofclans.add(daftar);
            if ((listClashofclans.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Clashofclans detailCoc = (Clashofclans)o;
        String Sid = detailCoc.get_id();
        String Susername = detailCoc.get_username();
        String Sbalaikota = detailCoc.get_balaikota();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iusername", Susername);
        goUpdel.putExtra("Ibalaikota", Sbalaikota);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listClashofclans.clear();
        mListView.setAdapter(adapter_off);
        List<Clashofclans> clashofclans = db.ReadMahasiswa();
        for (Clashofclans coc : clashofclans) {
            Clashofclans daftar = new Clashofclans();
            daftar.set_id(coc.get_id());
            daftar.set_username(coc.get_username());
            daftar.set_balaikota(coc.get_balaikota());
            listClashofclans.add(daftar);
            if ((listClashofclans.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}