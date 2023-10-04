package org.example.chapter7.exercise;

public class Exercise9 {
    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };

        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };

        System.out.println(symmetric(matrix1)); // true
        System.out.println(symmetric(matrix2)); // false
    }




    public static boolean symmetric(int[][] M) {
        int rows = M[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (M[i][j]!=M[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
