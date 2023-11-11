package org.chapter.chapter12.stop;

public class Quiz2 {
    public static void main(String[] args) {
        ThreadUnlimitedCounter runnableCounter = new ThreadUnlimitedCounter("counter");
        Thread.interrupted();


        runnableCounter.run();
    }
}
