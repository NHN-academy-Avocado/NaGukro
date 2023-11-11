package org.chapter.chapter12.runnable_interface_implement;

import org.chapter.chapter12.thread_class_extension.ThreadCounter;

public class Quiz2 {
    public static void main(String[] args) {
        ThreadCounter threadCounter = new ThreadCounter("threadCounter", 10);

        threadCounter.start();

    }
}
