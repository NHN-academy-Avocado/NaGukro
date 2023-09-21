package org.example.chapter7.exercise;

public class Exercise8 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8};
        //홀수가 4개
        System.out.println(mystery(A));

    }

    //요소가 홀수이면 x증가
    public static int mystery(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] % 2 == 1) x++;
        return x;
    }
}
