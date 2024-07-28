package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Writing
        System.out.println("Please enter the file path where you want to save your input:");
        String writePath = scanner.nextLine();
        WriteTask writeTask = new WriteTask(writePath);
        writeTask.execute();

        // Reading
        System.out.println("Please enter the file path from where you want to read the content:");
        String readFilePath = scanner.nextLine();
        ReadTask readTask = new ReadTask(readFilePath);
        readTask.execute();
    }
}
