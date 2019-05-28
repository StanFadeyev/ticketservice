package com.javaeducation.ticketservice;

import java.io.IOException;
import java.util.Scanner;

public class Ticketservice {

    private static Database ordersDatabase = new Database();

    public static void main(String[] args) throws Exception {

        Scanner ticketData = new Scanner(System.in);
        System.out.println("Enter command: ");
        String data = ticketData.nextLine();

        while (!data.equalsIgnoreCase("exit")) {

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

                System.out.println("Enter command: ");
                    data = ticketData.nextLine();
//                System.out.println("this is add");
                    break;
                }
                case UPDATE:
                    System.out.println("this is update");
                    break;
                case DELETE:
                    System.out.println("this is delete");
                    break;
                case SHOW:
                    System.out.println("this is show");
                    break;
                case SHOWALL:
                    System.out.println("this is showAll");
                    break;
/*                case EXIT:
                    System.out.println("this is exit");
                    break;*/
                case DEFAULT:
                    System.out.println(Command.DEFAULT.arguments);
                    break;


            }
            return;
        }
        if (data.equalsIgnoreCase("exit")) {
            System.out.println(Command.getCommand("exit").arguments);

        }
        ticketData.close();
    }
}