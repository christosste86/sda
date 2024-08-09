package com.sda.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOrArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(5);
        numbers.add(4);

        numbers.add(numbers.size(), 55);

        printNumber(numbers);

        LinkedList<Integer> numbers2 = new LinkedList<>();
        // printNumber(numbers2);

        List<Integer> numbers3 = new ArrayList<>();
        numbers.add(45);
        numbers.add(5);
        numbers.add(4);

        printNumber2(numbers);

        List<Integer> numbers4 = new LinkedList<>();

        printNumber2(numbers2);
        printNumber2(numbers3);
        printNumber2(numbers4);
    }

    static void printNumber(ArrayList<Integer> nums) {
        System.out.println(nums);
    }

    // ak pouzijem napr ArrayList, HashMap, TreeSet atd teda viac specifický objekt
    // uz tu funkciu nemozem pouzit na iny typ Listu, Mapu, alebo Setu...

    static void printNumber2(List<Integer> nums) {
        System.out.println(nums);
    }

    // ak pouzijem len Set, List, Map mouzem tu fuknciu pouzivat na vsetky typy toho druhu
}
