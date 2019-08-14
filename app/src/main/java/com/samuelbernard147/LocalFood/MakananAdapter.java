package com.samuelbernard147.LocalFood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Makanan> listMakanan;

    public ArrayList<Makanan> getListMakanan() {
        return listMakanan;
    }

    public void setListMakanan(ArrayList<Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    public MakananAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MakananAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_Makanan = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makanan, parent, false);
        return new CategoryViewHolder(item_Makanan);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.CategoryViewHolder holder, int position) {
        holder.nama.setText(getListMakanan().get(position).getNama());
        holder.desc.setText(getListMakanan().get(position).getDeskripsi());
        Picasso.get().load(getListMakanan().get(position).getGambar()).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return getListMakanan().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar;
        TextView nama, desc;

        CategoryViewHolder(View item_makanan) {
            super(item_makanan);
            gambar = itemView.findViewById(R.id.item_img);
            nama = itemView.findViewById(R.id.item_name);
            desc = itemView.findViewById(R.id.item_desc);
        }
    }
}
