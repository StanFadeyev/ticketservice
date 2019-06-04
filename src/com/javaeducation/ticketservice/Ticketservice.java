package com.javaeducation.ticketservice;

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
                    String[] input = data.substring(3).trim().split(",");
                    //Kurgin-style: делает трим по элементам массива //
                    //                  List<String> substr =  Arrays.asList(input).stream().map(s -> s.trim() ).collect(Collectors.toList());
                    if (input.length != 4) //throw new IOException("Need 4 params only!\n");
                    {
                        System.out.println("Need 4 params only!\n");
                        String error = "Need 4 params only!\n";
                        fileManager.writer(error);
                        break;
                    } else {

                        for (int i = 0; i < input.length; i++) {
                            input[i] = input[i].trim();
                        }
                        Order myObj = new Order(
                                input[0],
                                input[1],
                                input[2],
                                input[3]
                        );
                        String orderToFile = ordersDatabase.add(myObj);
                        fileManager.writer(orderToFile);
                        System.out.println("Order has been created!\n");
                    }
                    break;
                }
                case UPDATE: {
                    String[] substr = data.substring(6).trim().split(",");
                    if (substr.length != 5) //throw new IOException("Need 5 params only!");
                    {
                        System.out.println("Need 5 params only!\n");
                        String error = "Need 5 params only!\n";
                        fileManager.writer(error);
                        break;
                    }
                    String idSubstr = substr[0];
                    if (!ordersDatabase.checkId(idSubstr)) //throw new IOException("Wrong id!");
                    {
                        System.out.println("id does not exist, please enter a valid id! \n");
                        String error = "id does not exist, please enter a valid id! \n";
                        fileManager.writer(error);
                        break;
                    } else {
                        Order myObj = new Order(
                                substr[1],
                                substr[2],
                                substr[3],
                                substr[4]
                        );
                        String orderToFile = ordersDatabase.putValue(idSubstr, myObj);
                        fileManager.writer(orderToFile);
                        System.out.println("Order has been updated!");
                    }
                    break;
                }
                case DELETE: {
                    String[] substr = data.substring(6).trim().split(",");
                    String idSubstr = substr[0];
                    if (!ordersDatabase.checkId(idSubstr)) //throw new IOException("Wrong id!");
                    {
                        System.out.println("id does not exist, please enter a valid id! \n");
                        String error = "id does not exist, please enter a valid id! \n";
                        fileManager.writer(error);
                        break;
                    } else {
                        String orderToFile = ordersDatabase.deleteValue(idSubstr);
                        fileManager.writer(orderToFile);
                        System.out.println("Order has been deleted!");
                        break;
                    }
                }
                case SHOWALL: {
                    String result = ordersDatabase.getAll().toString();
                    if (result.length() == 0) {
                        fileManager.writer("Database is empty!");
                        System.out.println("Database is empty!");
                    } else {
                        fileManager.writer(result);
                    }
                    break;
                }
                case SHOW: {
                    String[] substr = data.substring(4).trim().split(",");
                    String idSubstr = substr[0];
                    if (!ordersDatabase.checkId(idSubstr)) //throw new IOException("Wrong id!");
                    {
                        System.out.println("id does not exist, please enter a valid id! \n");
                        String error = "id does not exist, please enter a valid id! \n";
                        fileManager.writer(error);
                        } else {
                        String orderToFile = ordersDatabase.showValue(idSubstr);
                        fileManager.writer(orderToFile);
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