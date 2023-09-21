package org.example.chapter7.exercise;

public class Exercise11 {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 0},
                {0, 3, 0},
                {0, 0, 6}
        };

        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };

        System.out.println(isdiagonalmatrix(matrix1)); // true
        System.out.println(isdiagonalmatrix(matrix2)); // false

    }
    public static boolean isdiagonalmatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i!=j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
