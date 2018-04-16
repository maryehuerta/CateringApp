package com.example.maryhuerta.cateringapp;

import java.io.Serializable;

/**
 * Created by mayur on 4/11/2018.
 */

public class UserModel implements Serializable {

    private int utaID;
    private String userFName;
    private String userLName;
    private String userEmail;
    private String userPassword;
    private String username;
    private int phoneNum;

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phone) {
        this.phoneNum = phone;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public int getId() {
        return utaID;
    }

    public void setId(int id) {
        this.utaID = id;
    }
}