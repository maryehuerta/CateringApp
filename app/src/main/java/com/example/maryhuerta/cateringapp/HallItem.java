package com.example.maryhuerta.cateringapp;

/**
 * Created by jimmy on 3/24/2018.
 */

public class HallItem {

    private String Hall;
    private String Capactiy;
    private String Time;

    public HallItem(String hall, String capactiy, String time) {
        Hall = hall;
        Capactiy = capactiy;
        Time = time;
    }

    public String getHall() {
        return Hall;
    }

    public String getCapactiy() {
        return Capactiy;
    }

    public String getTime() {
        return Time;
    }
}
