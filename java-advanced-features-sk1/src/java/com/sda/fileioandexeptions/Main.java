package com.sda.fileioandexeptions;

import com.sda.fileioandexeptions.errors.InvalidParkNameException;
import com.sda.fileioandexeptions.errors.MissingLocationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/java/com/sda/fileioandexeptions";
        String fileName = "parks.csv";
        String fileName2 = "parks2.csv";
        List<String> result = readFromFile(filePath, fileName);
        System.out.println(result);

        //writeToFile(filePath, fileName2, result);
        //appendToFile(filePath, fileName2, result);
//        for(String s : result){
//            System.out.println(s);
//        }
        try {
            validateContent(result);
        } catch (MissingLocationException e) {
            System.err.println("Missing Location information.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvalidParkNameException e) {
            System.err.println("Invalid name information.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // ukoncenie spojenia s db
        }

        try {
            System.out.println(222);
        } finally {

        }

    }

    public static List<String> readFromFile(String filePath, String name) {
        Path path = Paths.get(filePath + "/" + name);
        try {
            List<String> content = Files.readAllLines(path);
            content.remove(0);
            return content;
        } catch (IOException e) {
            System.err.println("File could not be read.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String filePath, String name, List<String> content) {
        Path path = Paths.get(filePath + "/" + name);
        try {
            Files.write(path, content, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.err.println("Unable to write to file.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void appendToFile(String filePath, String name, List<String> content) {
        Path path = Paths.get(filePath + "/" + name);
        try {
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to append to file.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void validateContent(List<String> text) throws MissingLocationException, InvalidParkNameException {
        for (String s : text) {
            int index = s.indexOf(",");
            String newString = s.substring(index + 1);
            String newString2 = s.substring(0, index);
            if (newString.isEmpty() || newString.isBlank()) {
                throw new MissingLocationException();
            }
           if (!newString2.contains("National Park")) {
                throw new InvalidParkNameException();
            }
        }
    }
}
