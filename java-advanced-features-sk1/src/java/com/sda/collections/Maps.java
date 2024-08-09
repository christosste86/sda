package com.sda.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Maps {
    public static void main(String[] args) {
        // Map - key value pair
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ArrayList<String> students = new ArrayList<>();
        students.add("Stefan");
        students.add("Tomas");
        students.add("Marek");

        hashMap.put("JavaRemoteSk1", students);

        // histogram pocet vyskytov niecoho v niecom

        String s = "cgub&nvjcn&szvkmzsojvxccjnnnno";

        LinkedHashMap<Character, Integer> histogram = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            histogram.put(c, histogram.getOrDefault(c, 0) + 1);

//            if (histogram.containsKey(c)){
//                int count = histogram.get(c);
//                count++;
//                histogram.put(c, count);
//            } else {
//                histogram.put(c, 1);
//            }
        }

        System.out.println(histogram);

        // HashMap - nahodne poradie hodnot

        // TreeMap - poradie napr. podla abecedy, od najmensieho po najvacsie atd.

        // LinkedHashMap - poradie ako sme tam elementy pridali

    }
}