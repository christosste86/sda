package com.sda.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lists {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Stefan");
        students.add("Tomas");
        students.add("Marek");


        students.set(1, "Lucia");
        students.remove("Lucia");
        ArrayList<String> students2 = new ArrayList<>();
        students2.add("Tomas");
        students2.add("Stefan");
        students2.add("Stefan");
        students2.add("Stefan");
        students2.add("Stefan");
        students.addAll(1, students2);

        students.remove("Stefan");

        System.out.println(students.contains("Stefan"));
        System.out.println(students.size());


        System.out.println(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + " " + students.get(i));
        }

        for (String student : students) {
            System.out.println(student);
        }


        for (String student : students) {
            if (student.toLowerCase().startsWith("s")) {
                System.out.println(student);
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).toLowerCase().startsWith("s")) {
                System.out.println(students.remove(i));
            }
        }

        System.out.println(students);

        for (Iterator<String> iterator = students.iterator(); iterator.hasNext(); ) {
            String item = iterator.next();
            if (item.toLowerCase().startsWith("s")) {
                iterator.remove();
            }

        }

        System.out.println(students);

        Set<String> studentsSet = new HashSet<>();
        studentsSet.add("Tomas");
        studentsSet.add("Stefan");
        studentsSet.add("Stefan");
        studentsSet.add("Stefan");
        studentsSet.add("Stefan");

        System.out.println(studentsSet);

        // List - moze obsahovat duplikaty

        // Set len unikatne hodnoty

        // HashSet - nahodne poradie hodnot

        // TreeSet - poradie napr. podla abecedy, od najmensieho po najvacsie atd.

        // LinkedHashSet - poradie ako sme tam elementy pridali



    }
}
