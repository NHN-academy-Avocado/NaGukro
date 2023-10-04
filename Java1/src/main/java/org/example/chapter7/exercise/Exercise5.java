package org.example.chapter7.exercise;

public class Exercise5 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {1, 2, 3, 4, 5};
        int[] C = {1, 2, 3, 4, 6};

        System.out.println(equalArrays(A, B)); // true
        System.out.println(equalArrays(A, C)); // false
    }

    public static boolean equalArrays(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i]!=B[i]) {
                return false;
            }
        }
        return true;
    }
}
