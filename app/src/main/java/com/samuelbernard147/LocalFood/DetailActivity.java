package com.samuelbernard147.LocalFood;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView Deskripsi, Penyajian, Bahan, Variasi;
    private ImageView Gambar;
    private String nama, gambar, deskripsi, penyajian, bahan, variasi;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_detail);

        Deskripsi = findViewById(R.id.txt_desc);
        Penyajian = findViewById(R.id.txt_penyajian);
        Bahan = findViewById(R.id.txt_bahan);
        Variasi = findViewById(R.id.txt_variasi);
        Gambar = findViewById(R.id.img_makanan);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString("NAMA");
        gambar = extras.getString("GAMBAR");
        deskripsi = extras.getString("DESKRIPSI");
        penyajian = extras.getString("PENYAJIAN");
        bahan = extras.getString("BAHAN");
        variasi = extras.getString("VARIASI");

        Deskripsi.setText(deskripsi);
        Penyajian.setText(penyajian);
        Bahan.setText(bahan);
        Variasi.setText(variasi);
        Picasso.get().load(gambar).into(Gambar);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(nama);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(nama);
        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.colorWhite));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.colorWhite));

    }
}
