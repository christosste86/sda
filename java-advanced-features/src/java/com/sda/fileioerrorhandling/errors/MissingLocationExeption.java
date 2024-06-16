package com.sda.fileioerrorhandling.errors;

public class MissingLocationExeption extends Exception{
    private String message = "Missing Location";

    @Override
    public String getMessage() {
        return message;
    }
}
