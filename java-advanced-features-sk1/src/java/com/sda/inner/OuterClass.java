package com.sda.inner;

public class OuterClass {
    private int number = 13;

    public void hello() {
        System.out.println("Hello from Outer class!");

        class LocalClass{ // vnutorna classa vo vnutri metody sa vola Local
            // jej instanciu vieme vytvorit len vo vnutri metody
            private int number = 8;

            public void hello() {
                System.out.println("Hello from Local class!");
            }

            @Override
            public String toString() {
                return "LocalClass{" +
                        "number=" + number +
                        '}';
            }
        }

        LocalClass localClass = new LocalClass();
        System.out.println(localClass);
        localClass.hello();
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "number=" + number +
                '}';
    }

    public class InnerClass{ // vnutorna classa sa vola inner
        // ked je non static potrebujeme mat vytvorenu instanciu OuterClassy aby sme si vedeli vytvorit inner takze potrebujeme
        // OuterClass oC = new OuterClass();
        // aby sme mohli spravit : OuterClass.InnerClass innerClass = oC.new InnerClass();
        private int number = 8;

        public void hello() {
            System.out.println("Hello from Inner class!");
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "number=" + number +
                    '}';
        }
    }

    public static class NestedClass{ // vnutorna staticka classa sa vola nested
        // ked je static nepotrebujeme mat vytvorenu instanciu OuterClassy aby sme si vedeli vytvorit nested
        // takze NEpotrebujeme OuterClass oC = new OuterClass();
        // aby sme mohli spravit : OuterClass.NestedClass nestedClass = new OuterClass.NestedClass();
        private int number = 8;

        public void hello() {
            System.out.println("Hello from Nested class!");
        }

        @Override
        public String toString() {
            return "NestedClass{" +
                    "number=" + number +
                    '}';
        }
    }
}
