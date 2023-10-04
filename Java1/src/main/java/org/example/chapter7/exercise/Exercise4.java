package org.example.chapter7.exercise;

public class Exercise4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] sums = matrixSumColumns(matrix);

        // Print out the sums of each column
        for (int sum : sums) {
            System.out.println(sum);
        }

    }

    public static int[] matrixSumColumns(int[][] matrix) {
        int rows = matrix[0].length;
        int[] result = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < rows; j++) {
                result[i] += matrix[i][j];
            }
        }
        return result;
    }
}

