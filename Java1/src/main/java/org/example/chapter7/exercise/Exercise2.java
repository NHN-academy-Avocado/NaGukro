package org.example.chapter7.exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {4, 5, 6, 7, 8};

        int[] result = intersection(A, B);
        for (int num : result) {
            System.out.print(num + " ");  // Outputs: 4 5
        }
    }

    static int[] intersection(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < B.length ; j++) {
                if (A[i] == B[j]) {
                    list.add(A[i]);
                }
            }
        }
        //int[] 로 바꿔줌
        int[] result = list.stream().mapToInt(i -> i).toArray();

        return result;
    }
}
