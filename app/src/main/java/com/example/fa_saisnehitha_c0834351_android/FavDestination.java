package com.example.fa_saisnehitha_c0834351_android;

public class FavDestination {
    int id;
    String address;
    Double favLatitude,favLongitude;
    String date;

    public FavDestination(int id, String address, Double favLatitude, Double favLongitude, String date) {
        this.id = id;
        this.address = address;
        this.favLatitude = favLatitude;
        this.favLongitude = favLongitude;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getFavLatitude() {
        return favLatitude;
    }

    public void setFavLatitude(Double favLatitude) {
        this.favLatitude = favLatitude;
    }

    public Double getFavLongitude() {
        return favLongitude;
    }

    public void setFavLongitude(Double favLongitude) {
        this.favLongitude = favLongitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
