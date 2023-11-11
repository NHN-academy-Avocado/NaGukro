package org.chapter.chapter12.runnable_interface_implement;

public class Exam1 {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("counter", 5);
        Thread thread = new Thread(counter);

        thread.start();
    }
}
