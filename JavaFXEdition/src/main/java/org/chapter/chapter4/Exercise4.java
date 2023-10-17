package org.chapter.chapter4;

public class Exercise4 {

    /**
     * 실험 "주어진 총합을 얻기 위해 주사위를 굴림"을 반복할 횟수입니다.
     * 프로그램은 각 가능한 주사위 눈의 경우에 대해 이 횟수만큼 실험을 수행하고,
     * 결과의 평균을 출력합니다.
     */
    public static final int NUMBER_OF_EXPERIMENTS = 10000;

    public static void main(String[] args) {
        double average;  // 주어진 총합을 얻기 위한 평균 주사위 굴린 횟수.
        System.out.println("주사위 총합     평균 주사위 굴린 횟수");
        System.out.println("------------     -------------------");
        for ( int dice = 2;  dice <= 12;  dice++ ) {
            average = getAverageRollCount( dice );
            System.out.printf("%10d%20.4f\n", dice, average);
            // 주사위에는 10개의 공간을, 평균에는 20개의 공간을 할당하여 출력합니다.
            // 소수점 이하 4자리까지 출력합니다.
        }
    }

    /**
     * 주어진 총합을 얻기 위해 주사위 한 쌍을 굴리는 평균 횟수를 계산합니다.
     * 실험은 NUMBER_OF_EXPERIMENTS 번 반복되며, 모든 실험에서의 평균 굴린 횟수가 계산됩니다.
     * 사전 조건: 주어진 총합은 2에서 12 사이여야 합니다.
     * @param roll 주사위에서 얻고자 하는 총합
     * @return 주어진 총합을 얻기 위한 평균 주사위 굴린 횟수
     */
    public static double getAverageRollCount( int roll ) {
        int rollCountThisExperiment;  // 한 번 실험에서 굴린 주사위 횟수.
        int rollTotal;  // 모든 실험에서의 총 주사위 굴린 횟수.
        double averageRollCount;  // 실험당 평균 주사위 굴린 횟수.
        rollTotal = 0;
        for ( int i = 0;  i < NUMBER_OF_EXPERIMENTS;  i++ ) {
            rollCountThisExperiment = rollFor( roll );
            rollTotal += rollCountThisExperiment;
        }
        averageRollCount = ((double)rollTotal) / NUMBER_OF_EXPERIMENTS;
        return averageRollCount;
    }

    /**
     * 주어진 총합이 나올 때까지 주사위 한 쌍을 굴립니다.
     * 사전 조건: 주어진 총합은 2에서 12 사이여야 합니다.
     * @param N 주사위에서 얻고자 하는 총합
     * @return 원하는 총합이 나오기 전에 주사위를 굴린 횟수
     * @throws IllegalArgumentException 주어진 매개변수 N이 주사위 한 쌍으로 나올 수 없는 숫자인 경우 발생합니다.
     */
    public static int rollFor( int N ) {
        if ( N < 2 || N > 12 )
            throw new IllegalArgumentException("주사위 한 쌍으로 나올 수 없는 총합입니다.");
        int die1, die2;  // 주사위를 나타내는 1에서 6 사이의 숫자.
        int roll;        // 주사위의 합계.
        int rollCt;      // 굴린 주사위 횟수.
        rollCt = 0;
        do {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            roll = die1 + die2;
            rollCt++;
        } while ( roll != N );
        return rollCt;
    }

}  // end DiceRollStats