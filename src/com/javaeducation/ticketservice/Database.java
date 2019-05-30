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
