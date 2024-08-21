package com.sda.concurrentprogramming;

public class FromRunnable implements Runnable{
    private int threadIndex;

    public FromRunnable(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(this.threadIndex + " ... " + i);
//            if(this.threadIndex == 8){
//                throw new RuntimeException();
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
