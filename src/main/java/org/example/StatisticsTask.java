package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsTask implements  Task{
    private List<Client> clients;


    public StatisticsTask(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void execute() throws IOException {
        List<Client> positiveBalanceClients = clients.stream().filter(client -> client.getBalance() >= 0).collect(Collectors.toList());
        List<Client> negativeBalanceClients = clients.stream().filter(client -> client.getBalance() < 0).collect(Collectors.toList());
        int sumPositive = positiveBalanceClients.stream().mapToInt(Client::getBalance).sum();
        int sumNegative = negativeBalanceClients.stream().mapToInt(Client::getBalance).sum();
        writeToFile("positive_balance.txt", positiveBalanceClients);
        writeToFile("negative_balance.txt", negativeBalanceClients);
        writeSummaryFile("summary.txt", sumPositive, sumNegative);
    }



    private void writeToFile(String fileName, List<Client> clients) throws  IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Client client:clients){
                writer.write(client.toString());
                writer.newLine();
            }
        }
    }

    private void writeSummaryFile(String fileName, int sumPositive, int sumNegative) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Sum of positive balances :"+ sumPositive);
            writer.newLine();
            writer.write("Sum of negative balances" + sumNegative);
        }
    }
}

