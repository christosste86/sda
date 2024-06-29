package com.sda.inner;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer);

        Outer.Inner inner = outer.new Inner();
        System.out.println(inner);

        Outer.Nested nested = new Outer.Nested();
        System.out.println(nested);

        outer.hello();

    }
}
