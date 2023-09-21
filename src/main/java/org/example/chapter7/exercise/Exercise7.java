package org.example.chapter7.exercise;

import java.util.Arrays;

public class Exercise7 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(Arrays.toString(RemoveDuplicates(A)));
    }


    public static int[] RemoveDuplicates(int[] A) {
        return Arrays.stream(A).distinct().toArray();
    }
}
