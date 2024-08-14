package com.sda.inner;

public class Main {
    public static void main(String[] args) {
        OuterClass oC = new OuterClass();
        System.out.println(oC);
        oC.hello();

        // InnerClass innerClass = new InnerClass();
        // OuterClass.InnerClass innerClass = new OuterClass().InnerClass();
        OuterClass.InnerClass innerClass = oC.new InnerClass();
        System.out.println(innerClass);
        innerClass.hello();

        OuterClass.NestedClass nestedClass = new OuterClass.NestedClass();
        System.out.println(nestedClass);
        nestedClass.hello();
    }
}
