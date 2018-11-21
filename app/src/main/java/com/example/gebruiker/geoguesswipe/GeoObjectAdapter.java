package com.example.gebruiker.geoguesswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder>{


    public List<GeoObject> listGeoObject;

    public GeoObjectAdapter( List<GeoObject> listGeoObject){
        this.listGeoObject = listGeoObject;
    }

    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new GeoObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position){
        final GeoObject geoObject = listGeoObject.get(position);
        holder.geoImage.setImageResource(geoObject.getmGeoImageName());
    }

    public int getItemCount(){
        return listGeoObject.size();
    }


}
