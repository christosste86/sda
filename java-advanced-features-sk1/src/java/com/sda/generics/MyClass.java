package com.sda.generics;

import com.sda.inheritence.Cat;

import java.util.ArrayList;
import java.util.List;

public class MyClass<T> {

//    t mi urcuje typ a vdaka tomu mozem vytvorit MyClass aj typu Interger, String dokonca aj mojho vlastneho ako Cat atd.T
//    Naming conventions:
//
//    E - Element (used e.g. for Java Collection API)
//    K - Key
//    N - Number
//    T - Typ
//    V - Value
    T t;

    public MyClass(T t) {
        this.t = t;
    }

    public T print(){
        System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        MyClass<Integer> i = new MyClass<>(5);
        MyClass<String> s = new MyClass<>("Hi");
        MyClass<Character> ch = new MyClass<>('L');
        MyClass<Cat> cat = new MyClass<>(new Cat());

        List<MyClass> list = new ArrayList<>();
        list.add(i);
        list.add(s);
        list.add(ch);
        list.add(cat);

        for (MyClass myClass : list){
            myClass.print();
        }
    }
}
