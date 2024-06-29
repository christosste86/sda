package com.sda.abstractclassesandinterfaces.comparable;

import com.sda.inner.Outer;

public class Main {
    public static void main(String[] args) {
        String s1 = "Apple";
        String s2 = "Banana";

        int result = s1.compareTo(s2);
        int result2 = s2.compareTo(s1);
        int result3 = s1.compareTo(s1);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

        if (result < 0){
            System.out.println(s1 + " comes before " + s2);
        } else if (result > 0) {
            System.out.println(s1 + " comes after " + s2);
        } else {
            System.out.println(s1 + " equels " + s2);
        }

//        int n1 = 5;
//        int n2 = 8;
//
//        int result = n1.compareTo(n2); neda sa na primitivnych typoch

        Integer n1 = 5;
        Integer n2 = 8;

        result = n1.compareTo(n2);
        result = Integer.compare(n1, n2);

        if (result < 0){
            System.out.println(n1 + " comes before " + n2);
        } else if (result > 0) {
            System.out.println(n1 + " comes after " + n2);
        } else {
            System.out.println(n1 + " equels " + n2);
        }

        Player player = new Player("Lucia", 1000);
        Player player2 = new Player("Bob", 500);

        result = player.compareTo(player2);

        if (result < 0){
            System.out.println(player.getName() + " has lower score than " + player2.getName());
        } else if (result > 0) {
            System.out.println(player.getName() + " has bigger score than " + player2.getName());
        } else {
            System.out.println(player.getName() + " has equal score with " + player2.getName());
        }
    }
}
