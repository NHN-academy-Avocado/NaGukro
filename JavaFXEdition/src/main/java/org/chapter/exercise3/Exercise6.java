package org.chapter.exercise3;

/**
 * 이 프로그램은 1에서 10000까지의 정수의 약수 개수를 계산합니다.
 * 최대 약수 개수를 찾습니다.
 * 최대 약수 개수와 그 범위 내에서 최대 약수 개수를 갖는 모든 정수의 리스트를 출력합니다.
 */

public class Exercise6 {

    public static void main(String[] args) {

        int N;            // 약수를 계산해야 하는 정수 중 하나.
        int maxDivisors;  // 지금까지 본 최대 약수의 개수.

        int[] saveCount;  // 각 숫자에 대한 약수의 개수를 저장하기 위한 배열

        saveCount = new int[10001];

        maxDivisors = 1;  // 1의 약수가 1개임을 알고 시작합니다.
        saveCount[1] = 1;

       /* 2에서 10000까지의 모든 N 값을 처리하고 배열에 모든 약수 개수를 저장합니다.
          현재 값보다 더 많은 약수를 가진 N 값을 찾을 때마다 maxDivisor 값을 업데이트 합니다.
       */

        for ( N = 2;  N <= 10000;  N++ ) {

            int D;  // N의 약수인지 테스트하기 위한 숫자.
            int divisorCount;  // N의 약수의 개수.

            divisorCount = 0;

            for ( D = 1;  D <= N;  D++ ) {  // N의 약수 개수를 계산합니다.
                if ( N % D == 0 )
                    divisorCount++;
            }

            saveCount[N] = divisorCount;  // 배열에 N의 개수를 기록합니다.

            if (divisorCount > maxDivisors) {
                maxDivisors = divisorCount;
            }

        }

        System.out.println("1과 10000 사이의 정수 중에서,");
        System.out.println("약수의 최대 개수는 " + maxDivisors + " 개였습니다.");
        System.out.println("그러한 약수를 가진 숫자들은:");
        for ( N = 1; N <= 10000; N++ ) {
            if ( saveCount[N] == maxDivisors ) {
                System.out.println( "   " + N );
            }
        }

    } // end main()

}  // end class 최대약수횟수배열사용
