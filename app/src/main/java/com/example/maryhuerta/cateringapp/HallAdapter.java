package com.example.maryhuerta.cateringapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    /**
     * Created by MaryHuerta on 4/04/2018.
     */

    public static class UserRequestedEventItem implements Parcelable {

        private String LastName;
        private String FirstName;
        private String Date;
        private String StartTime;
        private String Duration;
        private String HallName;
        private String EstAttendees;
        private String EventName;
        private String FoodType;
        private String Meal;
        private String MealFormality;
        private String DrinkType;
        private String EntertainmentItems;
        private String Status;


        public UserRequestedEventItem(String lastName, String firstName, String date, String startTime, String duration, String hallName, String estAttendees, String eventName, String foodType, String meal, String mealFormality, String drinkType, String entertainmentItems, String status) {
            LastName = lastName;
            FirstName = firstName;
            Date = date;
            StartTime = startTime;
            Duration = duration;
            HallName = hallName;
            EstAttendees = estAttendees;
            EventName = eventName;
            FoodType = foodType;
            Meal = meal;
            MealFormality = mealFormality;
            DrinkType = drinkType;
            EntertainmentItems = entertainmentItems;
            Status = status;
        }



        public String getLastName() {
            return LastName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getDate() {
            return Date;
        }

        public String getStartTime() {
            return StartTime;
        }

        public String getDuration() {
            return Duration;
        }

        public String getHallName() {
            return HallName;
        }

        public String getEstAttendees() {
            return EstAttendees;
        }

        public String getEventName() {
            return EventName;
        }

        public String getFoodType() {
            return FoodType;
        }

        public String getMeal() {
            return Meal;
        }

        public String getMealFormality() {
            return MealFormality;
        }

        public String getDrinkType() {
            return DrinkType;
        }

        public String getEntertainmentItems() {
            return EntertainmentItems;
        }

        public String getStatus() {
            return Status;
        }

        // https://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-parcelable
        public UserRequestedEventItem(Parcel in){
            String[] data = new String[14];
            in.readStringArray(data);

            this.LastName = data[0];
            this.FirstName = data[1];
            this.Date = data[2];
            this.StartTime = data[3];
            this.Duration = data[4];
            this.HallName = data[5];
            this.EstAttendees = data[6];
            this.EventName = data[7];
            this.FoodType = data[8];
            this.Meal = data[9];
            this.MealFormality = data[10];
            this.DrinkType = data[11];
            this.EntertainmentItems = data[12];
            this.Status = data[13];
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(new String[]{
                    this.LastName,
                    this.FirstName,
                    this.Date,
                    this.StartTime,
                    this.Duration,
                    this.HallName,
                    this.EstAttendees,
                    this.EventName,
                    this.FoodType,
                    this.Meal,
                    this.MealFormality,
                    this.DrinkType,
                    this.EntertainmentItems,
                    this.Status,
            });
        }

        public static final Creator CREATOR = new Creator() {

            @Override
            public com.example.maryhuerta.cateringapp.UserRequestedEventItem createFromParcel(Parcel parcel) {
                return new com.example.maryhuerta.cateringapp.UserRequestedEventItem(parcel);
            }

            @Override
            public com.example.maryhuerta.cateringapp.UserRequestedEventItem[] newArray(int size) {
                return new com.example.maryhuerta.cateringapp.UserRequestedEventItem[size];
            }
        };
    }

    /**
     * Created by Maryehuerta on 4/17/2018.
     */

    public static class AvailableStaffItem implements Parcelable {

        private String LastName;
        private String FirstName;
        private String Date;
        private String Time;
        private String Status;


        public AvailableStaffItem(String lastName, String firstName, String date, String time, String status) {
            LastName = lastName;
            FirstName = firstName;
            Date = date;
            Time = time;
            Status = status;
        }



        public String getLastName() {
            return LastName;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getDate() {
            return Date;
        }

        public String getTime() {
            return Time;
        }

        public String getStatus() {return Status; }

        // https://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-parcelable
        public AvailableStaffItem(Parcel in){
            String[] data = new String[5];
            in.readStringArray(data);

            this.LastName = data[0];
            this.FirstName = data[1];
            this.Date = data[2];
            this.Time = data[3];
            this.Status = data[4];

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(new String[]{
                    this.LastName,
                    this.FirstName,
                    this.Date,
                    this.Time,
                    this.Status,

            });
        }

        public static final Creator CREATOR = new Creator() {

            @Override
            public com.example.maryhuerta.cateringapp.AvailableStaffItem createFromParcel(Parcel parcel) {
                return new com.example.maryhuerta.cateringapp.AvailableStaffItem(parcel);
            }

            @Override
            public com.example.maryhuerta.cateringapp.AvailableStaffItem[] newArray(int size) {
                return new com.example.maryhuerta.cateringapp.AvailableStaffItem[size];
            }
        };
    }


}
