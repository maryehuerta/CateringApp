package com.example.maryhuerta.cateringapp;

/**
 * Created by jimmy on 3/24/2018.
 */

public class HallItem {

    private String HallName;
    private String HallCapacity;
    private String Time;

    public HallItem(String hall, String capactiy, String time) {
        HallName = hall;
        HallCapacity = capactiy;
        Time = time;
    }

    public String getHallName() {
        return HallName;
    }

    public String getHallCapacity() {
        return HallCapacity;
    }

    public String getTime() {
        return Time;
    }
}
