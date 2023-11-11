package org.chapter.chapter12.thread_class_extension;

public class Quiz2 {
    public static void main(String[] args) {
        ThreadCounter threadCounter = new ThreadCounter("ThreadCounter", 10);

        threadCounter.start();
    }
}
