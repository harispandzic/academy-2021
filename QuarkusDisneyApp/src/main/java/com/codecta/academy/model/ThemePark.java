package com.codecta.academy.model;

public class ThemePark extends ModelObject{
    private String location;
    private String attraction;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }
}
