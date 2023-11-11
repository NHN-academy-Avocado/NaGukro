package org.chapter.chapter12.stop;

public class Quiz1 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter0 = new RunnableCounter(50);
        RunnableCounter runnableCounter1 = new RunnableCounter(50);

        System.out.println(runnableCounter0.getName());
        System.out.println(runnableCounter1.getName());
        runnableCounter0.start();
        runnableCounter1.start();
        System.out.println(runnableCounter0.getName());
        System.out.println(runnableCounter1.getName());

        Thread.sleep(5000);
        runnableCounter0.stop();
    }
}
