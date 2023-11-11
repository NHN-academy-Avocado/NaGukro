package org.chapter.chapter12.runnable_interface_implement;

public class Quiz1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableCounter("runnableCounter", 10));

        thread.start();
    }
}
