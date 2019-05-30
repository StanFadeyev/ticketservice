package com.javaeducation.ticketservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Database {
    private Map<String, Order> db = new HashMap<>();

    private String getUniqId() {
        String id = UUID.randomUUID().toString();
        while (!db.containsKey(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    //TODO: что должен возвращать метод entrySet?

    /*public static String entrySet (Map<String, Order> db) {
        for (Map.Entry<String, Order> entry : db.entrySet()) {
            String id = entry.getKey();
            Order order = entry.getValue();
        }
        return ;
    }*/

    public String add(Order order) {

        String id = getUniqId();
        order.setId(id);
        db.put(id, order);
        return order.toString();
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
// TODO: удаление ключ-значения из мапы выполнять через Итератор



}
