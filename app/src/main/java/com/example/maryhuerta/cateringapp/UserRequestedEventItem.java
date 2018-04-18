package com.example.maryhuerta.cateringapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MaryHuerta on 4/04/2018.
 */

public class UserRequestedEventItem implements Parcelable {

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

    public java.lang.String getDate() {
        return Date;
    }

    public java.lang.String getStartTime() {
        return StartTime;
    }

    public java.lang.String getDuration() {
        return Duration;
    }

    public java.lang.String getHallName() {
        return HallName;
    }

    public java.lang.String getEstAttendees() {
        return EstAttendees;
    }

    public java.lang.String getEventName() {
        return EventName;
    }

    public java.lang.String getFoodType() {
        return FoodType;
    }

    public java.lang.String getMeal() {
        return Meal;
    }

    public java.lang.String getMealFormality() {
        return MealFormality;
    }

    public java.lang.String getDrinkType() {
        return DrinkType;
    }

    public java.lang.String getEntertainmentItems() {
        return EntertainmentItems;
    }

    public java.lang.String getStatus() {
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

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public HallAdapter.UserRequestedEventItem createFromParcel(Parcel parcel) {
            return new HallAdapter.UserRequestedEventItem(parcel);
        }

        @Override
        public HallAdapter.UserRequestedEventItem[] newArray(int size) {
            return new HallAdapter.UserRequestedEventItem[size];
        }
    };
}
