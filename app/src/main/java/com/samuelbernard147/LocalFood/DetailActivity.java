package com.samuelbernard147.LocalFood;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    private String nama, gambar, deskripsi, penyajian, bahan, variasi;
    @BindView(R.id.txt_desc)
    TextView Deskripsi;
    @BindView(R.id.txt_penyajian)
    TextView Penyajian;
    @BindView(R.id.txt_bahan)
    TextView Bahan;
    @BindView(R.id.txt_variasi)
    TextView Variasi;
    @BindView(R.id.img_makanan)
    ImageView Gambar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

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

        collapsingToolbarLayout.setTitle(nama);
        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.colorWhite));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.colorWhite));
    }
}