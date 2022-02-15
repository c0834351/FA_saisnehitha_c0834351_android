package com.example.fa_saisnehitha_c0834351_android;

public class FavDestination {
    int id;
    String address;
    Double Latitude, Longitude;
    String date;

    public FavDestination(String address, Double latitude, Double longitude, String date) {
        this.address = address;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.date = date;
    }

    public FavDestination(int id, String address, Double latitude, Double longitude, String date) {
        this.id = id;
        this.address = address;
        Latitude = latitude;
        Longitude = longitude;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public String getDate() {
        return date;
    }
}
