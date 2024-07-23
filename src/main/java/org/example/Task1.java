package org.example;

import java.io.*;

public class Task1 {
    String filePath;

    public Task1(String filePath){
        this.filePath = filePath;
    }

    public void readFileAndPrint(){
        File file = new File(filePath);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
