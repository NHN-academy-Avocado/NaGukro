package org.chapter.chapter5.exercise3;

import org.chapter.chapter5.exercise1.PairOfDice;
import org.chapter.chapter5.exercise2.StatCalc;

/**
 * 이 프로그램은 다음과 같은 실험을 수행합니다:
 * 원하는 총합 롤(예: 7)을 주사위 쌍을 굴려서 주어진 총합이 나올 때까지 굴리고, 몇 번 굴려야 하는지 세십니다.
 * 이제 실험을 반복하고 평균 굴린 횟수를 찾습니다. 실험을 반복하는 횟수는 상수 NUMBER_OF_EXPERIMENTS에 의해 지정됩니다.
 * 각 가능한 총합(2, 3, ..., 12)에 대해 여러 통계 정보가 계산되고 인쇄됩니다:
 * 평균 굴린 횟수, 표준 편차 및 최대 굴린 횟수.
 */

public class Exercise3 {

    static final int NUMBER_OF_EXPERIMENTS = 10000;

    private static PairOfDice dice = new PairOfDice();
    // 모든 실험에 사용될 단일 주사위 쌍.


    public static void main(String[] args) {

        System.out.println("주사위 총합      평균 굴린 횟수     표준 편차     최대 굴린 횟수");
        System.out.println("----------   --------------   ----------   --------------");

        for ( int total = 2;  total <= 12;  total++ ) {
            StatCalc stats;  // 통계를 계산할 객체.
            stats = new StatCalc();
            for ( int i = 0; i < NUMBER_OF_EXPERIMENTS; i++ ) {
                // 원하는 총합을 굴리는 실험을 수행하고 굴린 횟수를 통계 데이터 세트에 입력합니다.
                stats.enter( rollFor(total) );
            }
            System.out.printf("%6d", total);
            System.out.printf("%18.3f", stats.getMean());
            System.out.printf("%11.3f", stats.getStandardDeviation());
            System.out.printf("%14.3f", stats.getMax());
            System.out.println();
        }

    } // end main

    /**
     * 두 주사위의 합이 N이 될 때까지 주사위를 반복해서 굴립니다. N은 반드시 2, 3, ..., 12 중 하나여야 합니다.
     * (그렇지 않으면 이 루틴은 무한 루프에 빠질 것입니다!).
     * 굴린 횟수가 반환됩니다.
     */
    static int rollFor( int N ) {
        int rollCt = 0;  // 굴린 횟수.
        do {
            dice.roll();
            rollCt++;
        } while ( dice.getTotal() != N );
        return rollCt;
    }


}  // end class DiceRollStats2

