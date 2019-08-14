package com.samuelbernard147.LocalFood;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Makanan> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Local Food");
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(MakananData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        MakananAdapter makananAdapter = new MakananAdapter(this);
        makananAdapter.setListMakanan(list);
        rv.setAdapter(makananAdapter);

        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMakanan(list.get(position));
            }
        });
    }

    private void showSelectedMakanan(Makanan makanan){
        Toast.makeText(this, makanan.getNama(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this,DetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString("NAMA",makanan.getNama());
        extras.putString("GAMBAR",makanan.getGambar());
        extras.putString("DESKRIPSI",makanan.getDeskripsi());
        extras.putString("PENYAJIAN",makanan.getPenyajian());
        extras.putString("BAHAN",makanan.getBahan());
        extras.putString("VARIASI",makanan.getVariasi());
        i.putExtras(extras);
        startActivity(i);
    }
}
