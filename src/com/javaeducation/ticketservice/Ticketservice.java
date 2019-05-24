package com.javaeducation.ticketservice;

import java.util.Scanner;

public class Ticketservice {

    public static void main(String[] args)  {

        Scanner ticketData = new Scanner(System.in);
        System.out.println("Enter command: ");
        String data = ticketData.nextLine();

        switch (Command.getCommand(data)) {
            case ADD:

//                System.out.println(Command.ADD.arguments);
                break;
            case UPDATE:
//                System.out.println("this is update");
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
            case EXIT:
                System.out.println("this is exit");
                break;
            case DEFAULT:
                System.out.println(Command.DEFAULT.arguments);

                break;

        }
        ticketData.close();
    }
}