package org.chapter.chapter5.exercise1;

public class Exercise1 {
    public static void main(String[] args) {

        PairOfDice dice;  // 주사위를 참조하는 변수.
        int rollCount;    // 주사위가 굴린 횟수.

        dice = new PairOfDice();  // PairOfDice 객체를 생성합니다.
        rollCount = 0;

        /* 주사위가 두 번째 도출값이 2가 될 때까지 주사위를 굽니다. */

        do {
            dice.roll();
            System.out.println("주사위는 " + dice + "이 나왔습니다.");
            rollCount++;
        } while (dice.getTotal() != 2);

        /* 주사위 굴린 횟수를 보고합니다. */

        System.out.println("\n2가 나올 때까지 " + rollCount + "번 굴렸습니다.");

        /* 이제 예외를 발생시킵니다. */

        System.out.println();
        System.out.println("이 프로그램은 주사위 값을 42로 설정하려고 시도할 때 오류가 발생합니다.");
        System.out.println();

        dice.setDie1(42);
        System.out.println(dice);  // 이 문장은 실행되지 않습니다!

    }

}  // RollFor2 클래스 끝
