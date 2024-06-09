package com.sda.collections;

import java.util.*;

public class DiffLists {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        List<String> myList2 = new LinkedList<>();

        myList.add("Jiri");
        myList.add("Ivka");
        myList.add("Tomas");
        myList.add("Jiri");
        myList.add("Jiri");
        myList.add("Jiri");

        myList2.add("Jiri");
        myList2.add("Jiri");

        printList(myList);
        // printList3(myList2);

//        DiffLists diffLists = new DiffLists();
//        diffLists.printList2(myList);
    }

    public static void printList(List<String> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    } // methoda

    public static void printList3(LinkedList<String> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    } // methoda

    public void printList2(ArrayList<String> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    } // function
}
