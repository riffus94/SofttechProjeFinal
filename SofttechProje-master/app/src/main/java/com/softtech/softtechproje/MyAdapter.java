package com.softtech.softtechproje;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Museums> museumsArrayList;


    public MyAdapter(Context context, ArrayList<Museums> museumsArrayList) {
        this.context = context;
        this.museumsArrayList = museumsArrayList;
    }

    public MyAdapter(ArrayList<Museums> museumsArrayList) {
        this.museumsArrayList=museumsArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Museums museums = museumsArrayList.get(position);

        holder.name.setText(museums.name);
        holder.location.setText(museums.location);
        holder.address.setText(museums.address);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);

                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return museumsArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, location, address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            location = itemView.findViewById(R.id.tvLocation);
            address = itemView.findViewById(R.id.tvAddress);

        }
    }




}
