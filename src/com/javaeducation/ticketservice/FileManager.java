package com.javaeducation.ticketservice;

import java.io.*;

//write to file
// https://javarush.ru/groups/posts/593-bufferedreader-i-bufferedwritter

public class FileManager {

    public void writer (String text) throws IOException {
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
