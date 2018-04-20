package com.example.maryhuerta.cateringapp;

import java.io.Serializable;

/**
 * Created by mayur on 4/11/2018.
 */

public class UserModel implements Serializable {

    private String utaID;
    private String userFName;
    private String userLName;
    private String userEmail;
    private String userPassword;
    private String username;
    private String phoneNum;

    private String streetAddress;
    private String city;
    private String zipcode;
    private String state;
    private String usertype;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String address) {
        this.streetAddress = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsertype() {
            return usertype;
    }

    public void setUsertype(String usertype) {
            this.usertype = usertype;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phone) {
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

    public String getId() {
        return utaID;
    }

    public void setId(String id) {
        this.utaID = id;
    }
}