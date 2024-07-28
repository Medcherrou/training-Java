package org.example;

import java.io.*;
import java.util.Scanner;

public class WriteTask implements Task{

    private String filePath;


    public WriteTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() throws IOException {
        File file = new File(filePath);
        Scanner sc = new Scanner(System.in);

        if(file.isDirectory()){
            System.out.println("The specified path is a directory. Please enter the name of the file to be created in this directory:");
            String fileName = sc.nextLine();
            file = new File(filePath,fileName);
        }
        System.out.println(file);
        if(file.exists()){
            System.out.println("The file already exists.Choose an option:");
            System.out.println("1. Overwrite the file");
            System.out.println("2. Append to the file");
            System.out.println("3. Cancel the operation");
            String choice = sc.nextLine();

            switch (choice){
                case "1" :
                    writeFile(sc,file,false);
                    break;
                case "2":
                    writeFile(sc,file,true);
                    break;
                case "3":
                    System.out.println("Operation cancelled");
                    return;
                default:
                    System.out.println("Invalid choice. Operation canceled.");
                    return;
            }
        }else {
            writeFile(sc,file,false);
        }
    }

    private void writeFile(Scanner scanner,File file, boolean append) {
        System.out.println("Please enter the text to save to the file (end input with an empty line):");

        StringBuilder input = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            input.append(line).append(System.lineSeparator());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            bufferedWriter.write(input.toString());
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}

