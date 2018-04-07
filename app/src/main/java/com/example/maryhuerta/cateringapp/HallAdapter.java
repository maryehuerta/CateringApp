package com.example.maryhuerta.cateringapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Created by jimmy on 3/24/2018.
 */

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.ViewHolder>{

    Vector <HallItem> hallList;
    private Context context;

    public HallAdapter(Vector<HallItem> hallList, Context context) {
        this.hallList = hallList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hall_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HallItem currentHall = hallList.get(position);

        holder.TextViewHall.setText(currentHall.getHall());
        holder.TextViewCapacity.setText(currentHall.getCapactiy());
        holder.TextViewTime.setText(currentHall.getTime());
    }

    @Override
    public int getItemCount() {
        return hallList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView TextViewHall, TextViewCapacity, TextViewTime;

        public ViewHolder(View itemView) {
            super(itemView);

            TextViewHall = (TextView) itemView.findViewById(R.id.HallText);
            TextViewCapacity = (TextView) itemView.findViewById(R.id.CapacityText);
            TextViewTime = (TextView) itemView.findViewById(R.id.TimeText);
        }
    }
}
