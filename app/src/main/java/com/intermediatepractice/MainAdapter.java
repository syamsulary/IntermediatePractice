package com.intermediatepractice;

import android.app.VoiceInteractor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYAMSUL on 01/12/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<MainDao> data = new ArrayList<>();

    public MainAdapter(List<MainDao> data) {
        this.data = data;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main,parent,false));
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        holder.txt.setText(data.get(position).getTitle());
        Picasso.with(holder.img.getContext())
            .load(data.get(position).getImageUrl())
            .fit()
            .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MainHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt;

        public MainHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.row_image);
            txt = itemView.findViewById(R.id.row_title);
        }
    }
}
