package com.sda.fileioerrorhandling;

import com.sda.fileioerrorhandling.errors.InvalidParkNameExeption;
import com.sda.fileioerrorhandling.errors.MissingLocationExeption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/java/com/sda/fileioerrorhandling";
        String fileName = "parks.csv";
        List<String> result = readFromFile(filePath, fileName);
        System.out.println(result);
        for(String s : result){
            System.out.println(s);
        }

        try {
            validateContent(result);
        } catch (MissingLocationExeption e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvalidParkNameExeption e) {
            System.err.println("Invalid Park Name");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e){
            System.err.println("Other E");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // close scanner, close db
        }

        try {
            System.out.println("Hi");
        } finally {

        }
        // writeTo(filePath, "parks2.csv", result);

        //appendTo(filePath, "parks2.csv", result);
    }

    public static List<String> readFromFile(String filePath, String fileName) {
        Path p = Paths.get(filePath + "/" + fileName);
        try {
            List<String> content = Files.readAllLines(p);
            content.remove(0);
            return content;
        } catch (IOException e) {
            System.err.println("File could not be read!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void writeTo(String filePath, String fileName, List<String> content) {
        Path p = Paths.get(filePath + "/" + fileName);
        try {
            Files.write(p, content, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.err.println("Unable to write!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void appendTo(String filePath, String fileName, List<String> content) {
        Path p = Paths.get(filePath + "/" + fileName);
        try {
            Files.write(p, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to append!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void validateContent(List<String> content) throws MissingLocationExeption, InvalidParkNameExeption {
        for(String s : content){
            String[] data = s.split(",");
            if(data.length == 1){
                throw new MissingLocationExeption();
            }
            if(!data[0].contains("National Park")){
                throw new InvalidParkNameExeption();
            }
        }
    }
}
