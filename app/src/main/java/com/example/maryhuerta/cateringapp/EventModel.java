package com.example.maryhuerta.cateringapp;

import java.io.Serializable;

/**
 * Created by mayur on 4/11/2018.
 */

public class EventModel implements Serializable {


    private String eventName;
    private String firstName;
    private String lastName;
    private String date;
    private String timeOfEvent;
    private String duration;
    private String hallName;
    private String attendees;
    private String foodType;
    private String formality;
    private String mealType;
    private String reserved;
    private String specialItems;

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String address) {
        this.firstName = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String address) {
        this.lastName = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String address) {
        this.date = address;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String address) {
        this.duration = address;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String address) {
        this.hallName = address;
    }
    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String address) {
        this.attendees = address;
    }
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String address) {
        this.foodType = address;
    }
    public String getFormality() {
        return formality;
    }

    public void setFormality(String address) {
        this.formality = address;
    }
    public String getMealType() {
        return mealType;
    }

    public void setMealType(String address) {
        this.mealType = address;
    }
    public String getReserved() {
        return reserved;
    }

    public void setReserved(String address) {
        this.reserved = address;
    }
    public String getSpecialItems() {
        return specialItems;
    }

    public void setSpecialItems(String address) {
        this.specialItems = address;
    }


}