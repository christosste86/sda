package com.sda.abstractandinterfaces.diamondproblem;

public class D { // extends B, C - nieje mozne - classa d by nevedela ci ma tlacit b alebo c
    B b = new B();
    C c = new C(); // composition - riesenie takto ja urcim co sa bude tlacit

    void printLetter() {
        b.printLetter();
        c.printLetter();
    }

    public static void main(String[] args) {
       D d = new D();
       d.printLetter();
    }
}
