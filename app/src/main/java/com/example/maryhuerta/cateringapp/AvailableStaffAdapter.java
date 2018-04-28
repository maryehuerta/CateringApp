package com.example.maryhuerta.cateringapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mary on 3/30/2018.
 */

public class AvailableStaffAdapter extends RecyclerView.Adapter<AvailableStaffAdapter.ViewHolder>{

    public ArrayList <AvailableStaffItem> eventList;
    private static RecyclerViewClickListener itemListener;
    private Context context;

    public AvailableStaffAdapter(ArrayList<AvailableStaffItem> eventList, Context context, RecyclerViewClickListener listener) {
        this.eventList = eventList;
        this.context = context;
        itemListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_staff_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        AvailableStaffItem currentEvent = eventList.get(position);

        holder.firstNameText.setText(currentEvent.getFirstName());
        holder.dateText.setText(currentEvent.getDate());
        holder.lastNameText.setText(currentEvent.getLastName());
        holder.timeText.setText(currentEvent.getStartTime());
        holder.statusText.setText(currentEvent.getStatus());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public AvailableStaffItem getItem(int position){
        return eventList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView dateText, lastNameText,
                firstNameText, timeText, statusText;

        public ViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            lastNameText =  itemView.findViewById(R.id.lastNameText);
            timeText = itemView.findViewById(R.id.timeText);
            statusText = itemView.findViewById(R.id.statusText);
            firstNameText = itemView.findViewById(R.id.firstNameText);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getAdapterPosition());
        }


    }
}
