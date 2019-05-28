package com.javaeducation.ticketservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
   private Map<String, Order> db = new HashMap<>();

    private ArrayList <String> orderIds = new ArrayList<>();

    private String getUnicId () {
        String id = UUID.randomUUID().toString();
        while (orderIds.contains(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }


    public String add (Order order) {

        String id = getUnicId();
        order.setId(id);
        db.put(id,order);
        return order.toString();
    }


}
/*
//stores the entered data of the tickets

import java.util.ArrayList;
import java.util.UUID;

public class Database {
    ArrayList<Order> database = new ArrayList<>();
//    int id = 0;

    UUID uuid = new UUID(Long.MIN_VALUE, Long.MAX_VALUE);
    UUID a = uuid.fromString();

    // посмотреть видео, где выносится уникальный id - udemy;
    public String add(String[] args) {
        int id = (database.size() == 0 ? 1 : (database.size() - 1));
        */
/*if (database.size() == 0) {
            id = 0;
        } else {
            id = (database.size() - 1);
        }*//*

        String[] k = {" ", " ", " ", " "};

        for (int i = 0; i < args.length && i < k.length; i++) {
            k[i] = args[i];
        }
        Order s = new Order(k[0], k[1], k[2], k[3]);
        database.add(s);
        return s.toString();
    }
*/
/*    public String delete (int id){
        int index = -1;

    }*//*

}*/
