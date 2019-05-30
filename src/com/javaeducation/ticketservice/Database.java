package com.javaeducation.ticketservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    private Map<String, Order> db = new HashMap<>();

//    private ArrayList<String> orderIds = new ArrayList<>();

    private String getUniqId() {
        String id = UUID.randomUUID().toString();
        while (!db.containsKey(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    public String add(Order order) {

        String id = getUniqId();
        order.setId(id);
        db.put(id, order);
        return order.toString();
    }

    public boolean checkId(String id) {

        return db.containsKey(id);
    }

    public String showId(String showOrder) {
        db.get(showOrder);
        return showOrder;
    }

   /* public String show (Order order) {
        order.setId();

    }*/

}
