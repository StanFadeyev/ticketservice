package com.javaeducation.ticketservice;

//stores the entered data of the tickets

import java.util.ArrayList;

public class Database {
    ArrayList<Storage> database = new ArrayList<>();
    int id; //(database.size() == 0 ? 1 : (database.size() - 1));

    // посмотреть видео, где выносится уникальный id - udemy;
    public String add(String[] args) {

        if (database.size() == 0) {
            id = 0;
        } else {
            id = (database.size() - 1);
        }
        String[] k = {" ", " ", " ", " "};

        for (int i = 0; i < args.length && i < k.length; i++)
        {
            k[i] = args[i];
        }
        Storage s = new Storage(k[0], k[1], k[2], k[3]);
        database.add(s);
        return s.toString();
    }
   /* public String delete (){

    }*/
}
