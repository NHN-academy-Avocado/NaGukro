package org.chapter.exercise4;

public class Exercise3 {

    public static void main(String[] args) {
        int numberOfRolls;  // 2가 나올 때까지 던진 주사위 횟수.
        numberOfRolls = rollFor(2);
        System.out.println("뱀 눈을 얻기 위해 " + numberOfRolls + "번 주사위를 던졌습니다.");
    }  // end main()

    /**
     * 주어진 합계가 나올 때까지 주사위를 굴리는 시뮬레이션합니다.
     * 사전 조건: 원하는 합계는 2에서 12 사이여야 합니다.
     * @param N 주사위에서 얻고자 하는 총합
     * @return 원하는 총합이 나오기 전에 주사위를 굴린 횟수
     * @throws IllegalArgumentException 매개변수 N이 주사위 두 개로 나올 수 없는 숫자인 경우 발생합니다.
     */
    public static int rollFor( int N ) {
        if ( N < 2 || N > 12 )
            throw new IllegalArgumentException("두 개의 주사위로 나올 수 없는 총합입니다.");
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

}  // end class RollFor2

