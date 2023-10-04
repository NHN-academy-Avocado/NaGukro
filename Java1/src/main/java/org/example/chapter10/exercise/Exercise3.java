package org.example.chapter10.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println(ackermann(3,1));
    }
    static int count = 0;

    public static int ackermann(int m, int n) {
        count++;
        System.out.println(count);
        if ( m == 0) {
            return n+1;
        }
        if (n == 0) {
            return ackermann(m-1, 1);
        } else
            return ackermann(m-1, ackermann(m, n-1));
    }
}
