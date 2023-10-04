package org.example.chapter10.exercise;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacci (int num) {
        if (num==1) {
            return 1;
        }
        if (num==2) {
            return 1;
        }
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
