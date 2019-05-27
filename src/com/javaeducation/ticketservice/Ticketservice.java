package com.javaeducation.ticketservice;

import java.util.Scanner;

public class Ticketservice {

    public static void main(String[] args) throws Exception {

        Scanner ticketData = new Scanner(System.in);
        System.out.println("Enter command: ");
        String data = ticketData.nextLine();

        while (!data.equalsIgnoreCase("exit")) {

            switch (Command.getCommand(data)) {
                case ADD: {
                    String[] substr = data.substring(3).trim().split(",");
                    Database example = new Database();
                    System.out.println(example.id + " " + example.add(substr));
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
 /*               case EXIT:
                    System.out.println("this is exit");
                    break;
                case DEFAULT:
                    System.out.println("this is peace of sh#t");
                    break;*/

            }
           // wrong code hereinafter - need rework Command enum
            if (data.equalsIgnoreCase("exit")) {
                System.out.println((Command.getCommand(data).arguments));

            } else
                System.out.println((Command.getCommand(data).arguments));

            }
        ticketData.close();
    }
}