package com.softtech.softtechproje;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Museums> museumsArrayList;

    double latitude;
    double longitude;
    String markerName;


    MapsActivity mapsActivity = new MapsActivity();
    GoogleMap mMap;

    public MyAdapter(Context context, ArrayList<Museums> museumsArrayList) {
        this.context = context;
        this.museumsArrayList = museumsArrayList;
    }

    public MyAdapter() {
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

                //Log.d("coordinates", String.valueOf(museums.coordinates));
                latitude = museums.coordinates.getLatitude();
                longitude = museums.coordinates.getLongitude();
                markerName = museums.name;

                String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%f,%f?z=15(%s)", latitude, longitude, latitude, longitude, markerName);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);

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
