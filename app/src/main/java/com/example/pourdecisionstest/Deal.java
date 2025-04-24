package com.example.pourdecisionstest;

public class Deal {
    private String barName;
    private String dealDescription;

    public Deal(String barName, String dealDescription) {
        this.barName = barName;
        this.dealDescription = dealDescription;
    }

    public String getBarName() {
        return barName;
    }

    public String getDealDescription() {
        return dealDescription;
    }
}