package org.chapter.chapter12.runnable_interface_implement;

public class Exam2 {
    public static void main(String[] args) {
        SelfRunnableCounter counter = new SelfRunnableCounter("counter", 5);

        counter.start();
    }
}
