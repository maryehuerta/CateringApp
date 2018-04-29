package com.example.maryhuerta.cateringapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by jimmy on 3/24/2018.
 */

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.ViewHolder>{

    ArrayList<HallItem> hallList;
    private Context context;
    private RecyclerViewClickListener itemListener;


    public HallAdapter(ArrayList<HallItem> hallList, Context context, RecyclerViewClickListener listener) {
        this.hallList = hallList;
        this.context = context;
        itemListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hall_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HallItem currentHall = hallList.get(position);

        holder.TextViewHall.setText(currentHall.getHallName());
        holder.TextViewCapacity.setText(currentHall.getHallCapacity());
        holder.TextViewTime.setText(currentHall.getTime());
    }

    public HallItem getItem(int position){
        return hallList.get(position);
    }

    @Override
    public int getItemCount() {
        return hallList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView TextViewHall, TextViewCapacity, TextViewTime;

        public ViewHolder(View itemView) {
            super(itemView);

            TextViewHall = (TextView) itemView.findViewById(R.id.HallText);
            TextViewCapacity = (TextView) itemView.findViewById(R.id.CapacityText);
            TextViewTime = (TextView) itemView.findViewById(R.id.TimeText);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getAdapterPosition());
        }
    }


}