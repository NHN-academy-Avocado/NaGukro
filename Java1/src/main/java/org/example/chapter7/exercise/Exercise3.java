package org.example.chapter7.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        double[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] transposed = transposeMatrix(M);
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }




    public static double[][] transposeMatrix(double[][] M) {
        int colums = M.length;
        int rows = M[0].length;
        double[][] result = new double[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[i][j] = M[j][i];
            }
        }

        return result;
    }
}
