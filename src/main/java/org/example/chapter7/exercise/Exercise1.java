package org.example.chapter7.exercise;

public class Exercise1 {
    public static void main(String[] args) {
        double[] A = {3.0, 2.0, 1.0};
        double[] B = {4.0, 5.0, 6.0};
        System.out.println(scalarProduct(A, B));
    }
    public static double scalarProduct (double[] A, double[] B) {
        double result = 0.0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[i];
        }

        return result;
    }
}
