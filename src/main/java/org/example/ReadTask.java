package org.example;

import java.io.*;

public class ReadTask implements Task {
    String filePath;

    public ReadTask(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void execute() throws IOException {
        File file = new File(filePath);

        if (file.isDirectory()) {
            System.err.println("The specified path is a directory. Please provide a valid file path.");
            return;
        }

        if (!file.exists()) {
            System.err.println("The specified file does not exist.");
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
