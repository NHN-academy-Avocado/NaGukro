package org.chapter.chapter3;

public class Exercise2 {
    public static void main(String[] args) {
        int N;
        int maxDivisors;
        int numWithMax;

        maxDivisors = 1;
        numWithMax = 1;

        for ( N = 2;  N <= 10000;  N++ ) {

            int D;  // N을 나눌 수
            int divisorCount;  // Number of divisors of N.

            divisorCount = 0;

            for ( D = 1;  D <= N;  D++ ) {
                if ( N % D == 0 )
                    divisorCount++; //나눠지면 D는 N의 약수
            }

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
                numWithMax = N;
            }

        }

        System.out.println("1부터 10000까지 정수 중");
        System.out.println("가장 많은 약수 의 개는 " + maxDivisors);
        System.out.println("약수의 개수가 " + maxDivisors + " 인 정수는" + numWithMax);

    }
}
