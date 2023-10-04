package org.example.chapter7.exercise;

import java.util.Arrays;
import java.util.HashMap;

public class Exercise6 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1, 2, 3};

        System.out.println("중복값의 갯수 " + numberOfDuplicates(A));
        System.out.println("고유값의 갯수: " + numberOfDistinctValues(A));
    }

    //중볻된 숫자의 갯수
    public static int numberOfDuplicates(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i]>max) {
                max = A[i];
            }
        }
        int num = 0;

        for (int i = 0; i < max; i++) {
            int count= 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j]==i) {
                    count++;
                }
            }
            if (count > 1){
                num++;
            }
        }
        return num;

    }

    //숫자 종류
    public static int numberOfDistinctValues(int[] A) {
        return Arrays.stream(A).distinct().toArray().length;
    }

}
