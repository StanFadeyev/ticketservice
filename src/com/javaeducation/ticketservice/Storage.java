package com.javaeducation.ticketservice;

public class Storage {
    private String id;
    private String city;
    private String ownerName;
    private String date;
    private String raceNumber;

    public Storage(String id, String city, String raceNumber, String ownerName, String date) {
        this.id = id;
        this.city = city;
        this.ownerName = ownerName;
        this.date = date;
        this.raceNumber = raceNumber;
    }

    @Override
    public String toString() {
        return id + " " + city + " " + raceNumber + " " + ownerName + " " + date + "\n";
    }
}
