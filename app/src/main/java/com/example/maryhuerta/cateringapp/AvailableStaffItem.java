package com.example.maryhuerta.cateringapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MaryHuerta on 4/17/2018.
 */

public class AvailableStaffItem implements Parcelable {

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

    public java.lang.String getDate() {
        return Date;
    }

    public java.lang.String getStartTime() {
        return Time;
    }

    public java.lang.String getStatus() {
        return Status;
    }



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
                this.Status
        });
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public HallAdapter.AvailableStaffItem createFromParcel(Parcel parcel) {
            return new HallAdapter.AvailableStaffItem(parcel);
        }

        @Override
        public HallAdapter.AvailableStaffItem[] newArray(int size) {
            return new HallAdapter.AvailableStaffItem[size];
        }
    };
}
