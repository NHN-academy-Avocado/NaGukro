package org.chapter.chapter12.thread_class_extension;

public class Quiz1 {
    public static void main(String[] args) {

        Counter counter = new Counter("이름", 10);

        counter.run();
    }
}
