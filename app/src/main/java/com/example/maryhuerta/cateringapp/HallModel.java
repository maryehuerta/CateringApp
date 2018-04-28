package com.example.maryhuerta.cateringapp;

import java.io.Serializable;

/**
 * Created by maryhuerta on 4/27/18.
 */


public class HallModel implements Serializable {

    public HallModel(String hallName, int hallCapacity) {
        this.hallName = hallName;
        this.hallCapacity = hallCapacity;
        //this.hallBuiling = hallBuiling;
        //this.hallFloor = hallFloor;
    }
    public HallModel(){

    }

    public HallModel( ) {
    }

    private String hallName;
    private int hallCapacity;
    //private String hallBuiling;
    //private String hallFloor;

    public String getHallName() {
        return hallName;
    }

    public int getHallCapacity() {
        return hallCapacity;
    }

    /*public String getHallBuiling() {
        return hallBuiling;
    }*/

    /*public String getHallFloor() {
        return hallFloor;
    }*/

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setHallCapacity(int hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    /*public void setHallBuiling(String hallBuiling) {
        this.hallBuiling = hallBuiling;
    }

    public void setHallFloor(String hallFloor) {
        this.hallFloor = hallFloor;
    }*/
}