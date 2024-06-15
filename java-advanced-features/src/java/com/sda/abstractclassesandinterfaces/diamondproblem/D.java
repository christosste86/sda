package com.sda.abstractclassesandinterfaces.diamondproblem;

public class D implements E, F { //extends B , C neda sa

    B b = new B();
    C c = new C(); // composition

    void test(){
        b.printLetter();
        c.printLetter();
    }
    public static void main(String[] args) {
        D d = new D();
        d.test();
    }

    @Override
    public void meow() {

    }
}
