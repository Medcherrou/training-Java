package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

        // Reading Clients Information
        System.out.println("Please enter the file path from where you want to read the content:");
        String readFilePathClients = scanner.nextLine();
        ReadClientsTask readClientsTask = new ReadClientsTask(readFilePathClients);
        readClientsTask.execute();

        // Generating statistics
        List<Client> clients = readClientsTask.getClients();
        StatisticsTask statisticsTask = new StatisticsTask(clients);
        statisticsTask.execute();


    }
}
