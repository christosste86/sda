package com.sda.annotations;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VeryImportant
public class Cat {

    // ^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$

    @ImportantField
    private String name;
    private int age;

    @EmailFormat
    private String email;

    @RunImmediatly(times = 3)
    public void meow() {
        System.out.println("meow");
    }

    public void eat() {
        System.out.println("ham ham");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws NoSuchFieldException {
        if (isEmailValid(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmailValid(String email) throws NoSuchFieldException {
        String pattern = getEmailPatter();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private String getEmailPatter() throws NoSuchFieldException {
        Field f = this.getClass().getDeclaredField("email");
        return f.getAnnotation(EmailFormat.class).pattern();
    }

}
