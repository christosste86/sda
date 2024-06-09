package com.sda.collections;

import java.util.*;

public class Lists {
    public static void main(String[] args) {
        int[] a = new int[]{1};

        List<String> myList = new ArrayList<>();

        myList.add("Jiri");
        myList.add("Ivka");
        myList.add("Tomas");
        myList.add("Jiri");
        myList.add("Jiri");
        myList.add("Jiri");

        myList.set(1, "Petr");
        myList.add(1, "Rasto");
        myList.remove(1);
        if (myList.contains("Jiri")) {
            myList.remove("Jiri");
        }

        ArrayList<String> myList2 = new ArrayList<>();

        myList2.add("Jiri");
        myList2.add("Ivka");
        myList2.add("Tomas");

        myList.addAll(3, myList2);

        System.out.println(myList);

        System.out.println(myList.size());

        System.out.println(myList.get(myList.size() - 1));

        for (String s : myList) {
            System.out.println(s);
        }

        for (int i = 1; i <= myList.size(); i++) {
            System.out.println(i + ". " + myList.get(i - 1));
        }

        System.out.println("....");

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).toLowerCase().startsWith("j")) {
                System.out.println(myList.get(i).toLowerCase());
            }
        }

        System.out.println("....");
        System.out.println(myList);

//        for (int i = 0; i < myList.size(); i++) {
//            if(myList.get(i).toLowerCase().startsWith("j")){
//               myList.remove(i);
//            }
//        } - nefunguje

//        for (Iterator<String> i = myList.iterator(); i.hasNext();){
//            String item = i.next();
//
//            if(item.toLowerCase().startsWith("j")){
//                i.remove();
//            }
//        }

        Iterator<String> iterator = myList.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();

            if (item.toLowerCase().endsWith("i")) {
                iterator.remove();
            }
        }

        System.out.println(myList);

        myList.add("Jiri");
        myList.add("Jiri");
        myList.add("Jiri");

        System.out.println(myList);

        Set<String> myset = new HashSet<>();

        myset.addAll(myList);

        System.out.println(myset);

    }
}
