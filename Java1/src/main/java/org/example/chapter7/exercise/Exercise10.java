package org.example.chapter7.exercise;

public class Exercise10 {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 0},
                {2, 3, 0},
                {4, 5, 6}
        };

        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };

        System.out.println(islowertriangular(matrix1)); // true
        System.out.println(islowertriangular(matrix2)); // false
    }


    public static boolean islowertriangular(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j > i && matrix[i][j] != 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
