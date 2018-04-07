package com.example.maryhuerta.cateringapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Created by Mary on 3/30/2018.
 */

public class UserRequestedEventsAdapter extends RecyclerView.Adapter<UserRequestedEventsAdapter.ViewHolder>{

    public ArrayList <UserRequestedEventItem> eventList;
    private static RecyclerViewClickListener itemListener;
    private Context context;

    public UserRequestedEventsAdapter(ArrayList<UserRequestedEventItem> eventList, Context context, RecyclerViewClickListener listener) {
        this.eventList = eventList;
        this.context = context;
        itemListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_requested_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserRequestedEventItem currentEvent = eventList.get(position);

        holder.drinkTypeText.setText(currentEvent.getDrinkType());
        holder.entertainmentItemsText.setText(currentEvent.getEntertainmentItems());
        holder.firstNameText.setText(currentEvent.getFirstName());
        holder.date.setText(currentEvent.getDate());


    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public UserRequestedEventItem getItem(int position){
        return eventList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView durationText, date, lastNameText,
                firstNameText, startTimeText, hallNameText,
                estAttendeesText, eventNameText, foodTypeText,
                mealText, mealFormalityText, drinkTypeText,
                entertainmentItemsText, statusText;



        public ViewHolder(View itemView) {
            super(itemView);
            durationText = itemView.findViewById(R.id.durationText);
            date = itemView.findViewById(R.id.date);
            lastNameText =  itemView.findViewById(R.id.lastNameText);
            startTimeText = itemView.findViewById(R.id.startTimeText);
            hallNameText = itemView.findViewById(R.id.hallNameText);
            estAttendeesText = itemView.findViewById(R.id.estAttendeesText);
            eventNameText = itemView.findViewById(R.id.eventNameText);
            foodTypeText =  itemView.findViewById(R.id.foodTypeText);
            mealText = itemView.findViewById(R.id.mealText);
            mealFormalityText = itemView.findViewById(R.id.mealFormalityText);
            drinkTypeText = itemView.findViewById(R.id.drinkTypeText);
            statusText = itemView.findViewById(R.id.statusText);
            firstNameText = itemView.findViewById(R.id.firstNameText);
            entertainmentItemsText = itemView.findViewById(R.id.entertainmentItemsText);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getAdapterPosition());
        }


    }
}
