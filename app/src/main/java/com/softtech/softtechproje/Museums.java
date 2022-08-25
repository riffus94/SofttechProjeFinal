package com.softtech.softtechproje;

import com.google.firebase.firestore.GeoPoint;

public class Museums {

    String name, location, address;
    GeoPoint coordinates;

    public Museums(){}

    public Museums(String name, String location, String address,GeoPoint coordinates) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.coordinates = coordinates;
    }


    public GeoPoint getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GeoPoint coordinates) {
        this.coordinates = coordinates;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
