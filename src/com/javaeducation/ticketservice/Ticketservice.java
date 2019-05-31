package com.javaeducation.ticketservice;

import java.io.IOException;
import java.util.Scanner;

public class Ticketservice {

    private static Database ordersDatabase = new Database();
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) throws Exception {

        Scanner ticketData = new Scanner(System.in);
        readLoop:
        do {
            System.out.println("Enter command: ");
            String data = ticketData.nextLine().trim();
            switch (Command.getCommand(data)) {
                case ADD: {
                    String[] substr = data.substring(3).trim().split(",");
                    if (substr.length != 4) throw new IOException("Need 4 params only!");

                    Order myObj = new Order(
                            substr[0],
                            substr[1],
                            substr[2],
                            substr[3]
                    );
                    String orderToFile = ordersDatabase.add(myObj);
                    fileManager.writer(orderToFile);
                    System.out.println("Order has been created!");
                    break;
                }
                case UPDATE: {
                    String[] substr = data.substring(5).trim().split(",");
                    if (substr.length != 5) throw new IOException("Need 5 params only!");
                    String idSubstr = substr[0];
                    if (ordersDatabase.checkId(idSubstr)) throw new IOException("Wrong id!");
                    Order myObj = new Order(
                            substr[1],
                            substr[2],
                            substr[3],
                            substr[4]
                    );
                    String orderToFile = ordersDatabase.putValue(idSubstr, myObj);
                    fileManager.writer(orderToFile);
                    System.out.println("Order has been updated!");
                    break;
                }
                case DELETE: {
                    String[] substr = data.substring(5).trim().split(",");
                    String idSubstr = substr[0];
                    if (ordersDatabase.checkId(idSubstr)) throw new IOException("Wrong id!");
                    String orderToFile = ordersDatabase.deleteValue(idSubstr);
                    fileManager.writer(orderToFile);
                    System.out.println("Order has been deleted!");
                    break;
                    }
                case SHOW: {
                    String[] substr = data.substring(4).trim().split(",");
                    String idSubstr = substr[0];
                    if (ordersDatabase.checkId(idSubstr)) throw new IOException("Wrong id!");
                    String orderToFile = ordersDatabase.showValue(idSubstr);
                    fileManager.writer(orderToFile);
                    break;
                }
                case SHOWALL: {
                    String result = ordersDatabase.getAll().toString();
                    if (result.length() == 0) {
                        fileManager.writer("Database is empty!");
                    } else {
                        fileManager.writer(result);
                    }
                    break;
                }
                case EXIT: {
                    System.out.println(Command.EXIT.arguments);
                    break readLoop;
                }
                case DEFAULT: {
                    System.out.println(Command.DEFAULT.arguments);
                    break;
                }
            }

        } while (true);
        ticketData.close();
    }
}