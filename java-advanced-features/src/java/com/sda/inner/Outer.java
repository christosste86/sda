package com.sda.inner;

public class Outer {
    private int number = 6;
    private String text = "outer";

    public void hello(){
        System.out.println("Hello from Outer Class!");

        class Local {
            private int number = 6;
            private String text = "outer";
            public void hello(){
                System.out.println("Hello from Local Class!");
            }

            @Override
            public String toString() {
                return "Local{" +
                        "number=" + number +
                        ", text='" + text + '\'' +
                        '}';
            }
        }
        Local local = new Local();
        System.out.println(local);
        local.hello();
    }

    @Override
    public String toString() {
        return "Outer{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }

    public class Inner {
        private int number = 8;
        private String text = "inner";

        public void hello(){
            System.out.println("Hello from Inner Class!");
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "number=" + number +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    public static class Nested{
        private int number = 8;
        private String text = "nested";

        public void hello(){
            System.out.println("Hello from Nested Class!");
        }

        @Override
        public String toString() {
            return "Nested{" +
                    "number=" + number +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

}
