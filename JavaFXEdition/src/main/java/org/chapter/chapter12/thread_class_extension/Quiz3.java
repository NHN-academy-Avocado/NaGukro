package org.chapter.chapter12.thread_class_extension;

public class Quiz3 {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);

        counter1.run();
        counter2.run();

        //한줄찍 실행되기 때문에 이런 형식으로 출력
//counter1 : 1
//counter1 : 2
//counter1 : 3
//counter1 : 4
//counter1 : 5
//counter1 : 6
//counter1 : 7
//counter1 : 8
//counter1 : 9
//counter1 : 10
//counter2 : 1
//counter2 : 2
//counter2 : 3
//counter2 : 4
//counter2 : 5
//counter2 : 6
//counter2 : 7
//counter2 : 8
//counter2 : 9
//counter2 : 10

    }
}
