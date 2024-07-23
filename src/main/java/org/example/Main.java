package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\DeLL\\Downloads\\file.txt";
        Task1 task1 = new Task1(filePath);
        task1.readFileAndPrint();

    }
}
