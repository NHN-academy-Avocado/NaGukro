package org.chapter.chapter5.exercise1;

/**
 * PairOfDice 클래스는 1부터 6까지의 숫자를 표시하는 두 개의 주사위를 나타냅니다.
 * 주사위를 굴릴 수 있으며, 굴린 결과는 무작위의 값으로 설정됩니다.
 */
public class PairOfDice {

    private int die1;   // 첫 번째 주사위의 값.
    private int die2;   // 두 번째 주사위의 값.

    /**
     * 생성자는 두 개의 주사위를 만들고 초기에는 무작위 값이 표시되도록 합니다.
     */
    public PairOfDice() {
        roll();  // 주사위를 굴려 초기 값을 설정합니다.
    }

    /**
     * 주사위를 굴려서 각 주사위를 1부터 6 사이의 무작위 값으로 설정합니다.
     */
    public void roll() {
        die1 = (int)(Math.random() * 6) + 1;
        die2 = (int)(Math.random() * 6) + 1;
    }

    /**
     * 첫 번째 주사위의 값을 반환합니다.
     */
    public int getDie1() {
        return die1;
    }

    /**
     * 첫 번째 주사위의 값을 설정합니다. 값이 1에서 6 사이가 아닌 경우 IllegalArgumentException을 throw합니다.
     */
    public void setDie1(int value) {
        if (value < 1 || value > 6)
            throw new IllegalArgumentException("잘못된 주사위 값 " + value);
        die1 = value;
    }

    /**
     * 두 번째 주사위의 값을 반환합니다.
     */
    public int getDie2() {
        return die2;
    }

    /**
     * 두 번째 주사위의 값을 설정합니다. 값이 1에서 6 사이가 아닌 경우 IllegalArgumentException을 throw합니다.
     */
    public void setDie2(int value) {
        if (value < 1 || value > 6)
            throw new IllegalArgumentException("잘못된 주사위 값 " + value);
        die2 = value;
    }

    /**
     * 두 주사위의 합계를 반환합니다.
     */
    public int getTotal() {
        return die1 + die2;
    }

    /**
     * 두 주사위의 값을 나타내는 문자열 표현을 반환합니다. die1과 die2는 주사위에 표시된 값입니다.
     */
    public String toString() {
        if (die1 == die2)
            return "두 번 " + die1;
        else
            return die1 + "와 " + die2;
    }

}  // PairOfDice 클래스 끝

