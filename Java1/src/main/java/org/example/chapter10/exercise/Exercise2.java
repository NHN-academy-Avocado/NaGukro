package org.example.chapter10.exercise;

public class Exercise2 {    public static void main(String[] args) {
    fibonacci(10);
//    System.out.println(fibonacci(10));
}
static int count = 0;

    public static int fibonacci (int num) {
        if (num==1) {
            return 1;
        }
        if (num==2) {
            return 1;
        }
        count++;
        System.out.println(count);
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
