package com.javaeducation.ticketservice;

public enum Command {
    ADD, UPDATE, DELETE, SHOW, SHOWALL, EXIT, DEFAULT;
    String arguments = "";

    static Command getCommand(String str) {
        str = str.toLowerCase();
        if (str.startsWith("add")) {
            Command cmd1 = ADD;
            cmd1.arguments = "add";
            return cmd1;
        } else if (str.startsWith("update")) {
            Command cmd2 = UPDATE;
            cmd2.arguments = "update";
            return cmd2;
        } else if (str.startsWith("delete")) {
            Command cmd3 = DELETE;
            cmd3.arguments = "delete";
            return cmd3;
        }else if (str.startsWith("showall")) {
            Command cmd5 = SHOWALL;
            cmd5.arguments = "showAll";
            return cmd5;
        }else if (str.startsWith("show")) {
            Command cmd4 = SHOW;
            cmd4.arguments = "show";
            return cmd4;
        } else if (str.startsWith("exit")) {
                Command cmd6 = EXIT;
                cmd6.arguments = "exit";
                return cmd6;
            } else {
                Command cmd7 = DEFAULT;
                cmd7.arguments = "Wrong command. I'm tired, I'm leaving!";
                return cmd7;
            }
        }

    }

