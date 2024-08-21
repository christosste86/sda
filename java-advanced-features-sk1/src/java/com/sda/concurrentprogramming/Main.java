package com.sda.concurrentprogramming;

public class Main {
    public static void main(String[] args) {
//        FromThread fromThread1 = new FromThread();
//        FromThread fromThread2 = new FromThread();

//        fromThread1.run();
//        fromThread2.run();
//        fromThread1.start();
//        fromThread2.start();
//        for (int i = 0; i <= 10 ; i++) {
//            FromThread fromThread = new FromThread(i);
//            fromThread.start();
//        }
        // throw new RuntimeException();

        for (int i = 0; i <= 10 ; i++) {
            FromRunnable fromRunnable = new FromRunnable(i);
            Thread thread = new Thread(fromRunnable);
            thread.start();
        }

    }
}
