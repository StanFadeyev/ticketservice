package com.javaeducation.ticketservice;

import java.util.*;

public class Database {
    private Map<String, Order> db = new HashMap<>();

    private String getUniqId() {
        String id = UUID.randomUUID().toString();
        while (db.containsKey(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    public StringBuilder getAll() {
        StringBuilder builder = new StringBuilder();
        db.values().forEach(builder::append);
        return builder;
    }

    public String add(Order order) {

        String id = getUniqId();
        order.setId(id);
        db.put(id, order);
        return order.toString();
    }
    public String deleteValue (String id) {
        return db.remove(id).toString();
    }


    public boolean checkId(String id) {

        return db.containsKey(id);
    }

    public String showValue(String id) {

        return db.get(id).toString();
    }

    public  String putValue (String id, Order order) {

        order.setId(id);
        db.put(id, order);
        return order.toString();
    }
}
