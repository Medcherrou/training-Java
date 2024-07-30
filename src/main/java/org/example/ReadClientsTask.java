package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadClientsTask implements Task{

    private String filePath;
    private List<Client> clients;

    public ReadClientsTask(String filePath) {
        this.filePath = filePath;
        clients = new ArrayList<>();
    }

    @Override
    public void execute() throws IOException {
        File file= new File(filePath);
        if (file.isDirectory()) {
            System.err.println("The specified path is a directory. Please provide a valid file path.");
            return;
        }

        if (!file.exists()) {
            System.err.println("The specified file does not exist.");
            return;
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) !=null){
                String[] parts = line.trim().split("\\s+");
                if(parts.length == 4){
                    String idCompte = parts[0];
                    String nom = parts[1];
                    String prenom = parts[2];
                    int balance = Integer.parseInt(parts[3]);
                    clients.add(new Client(idCompte,nom,prenom,balance));
                }
            }

        }catch (IOException e){
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public List<Client> getClients() {
        return clients;
    }
}
