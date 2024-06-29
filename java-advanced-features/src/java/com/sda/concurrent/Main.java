package com.sda.concurrent;

public class Main {
    public static void main(String[] args) {
//        FromThread fromThread1 = new FromThread();
//        FromThread fromThread2 = new FromThread();

//        fromThread.run(); // no concurrent
//        fromThread2.run();
//        fromThread1.start();
//        fromThread2.start();
//        for (int i = 0; i <= 10; i++) {
//            FromThread fromThread = new FromThread(i);
//            fromThread.start();
//        }

        // throw new RuntimeException();

        for (int i = 0; i <= 10; i++) {
            FromRunnable fromRunnable = new FromRunnable(i);
            Thread thread = new Thread(fromRunnable);
            thread.start();
        }

        // runnable vs thread - better runnable mozme extednut len jednu class ale impement viav interfaces
    }
}
