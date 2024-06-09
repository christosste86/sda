package com.sda.collections;

import java.util.*;

public class Maps {

    // key value pair
    public static void main(String[] args) {
        Map<String, List<String>> myMap = new HashMap<>();
        myMap.put("JavaRemoteCZ12", List.of("Rasto", "Petr", "Ivka"));

        System.out.println(myMap);

        // histogram pocet vyskytov niecoho v niecom

        String s = "nwfinweoigvnmewroikosdmd";

        Map<Character, Integer> histogram = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            histogram.put(ch, histogram.getOrDefault(ch, 0) + 1);
//            System.out.println(ch);
//            if (histogram.containsKey(ch)){
//                histogram.put(ch, histogram.get(ch) + 1);
//            } else {
//                histogram.put(ch, 1);
//            }
        }

        System.out.println(histogram);
        System.out.println(histogram);
        System.out.println(histogram);
    }
}
