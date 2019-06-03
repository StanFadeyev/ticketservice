package com.javaeducation.ticketservice;

public class Order {
    private String id;
    private String city;
    private String ownerName;
    private String date;
    private String raceNumber;

    public Order(//String id,
                 String city, String raceNumber, String ownerName, String date) {
        //this.id = id;
        this.city = city;
        this.ownerName = ownerName;
        this.date = date;
        this.raceNumber = raceNumber;
    }

    public void setId(String id) {
        this.id = id;
    }


    //  toString() нужен для вывода читабельных параметров объекта, а не ссылки на объект
    @Override
    public String toString() {
        return id + ", " + city + ", " + raceNumber + ", " + ownerName + ", " + date + "\n";
    }


}
