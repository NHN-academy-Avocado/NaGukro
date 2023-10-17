package org.chapter.chapter5.exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        StatCalc calc; // 사용자가 입력한 숫자에 대한 통계를 계산합니다.
        calc = new StatCalc();

        double item; // 사용자가 입력한 하나의 숫자.

        System.out.println("숫자를 입력하세요.  0을 입력하면 종료됩니다.");
        System.out.println();

        do {
            System.out.print("? ");
            item = in.nextDouble();
            if (item != 0)
                calc.enter(item);
        } while (item != 0);

        System.out.println("\n데이터에 대한 통계:\n");
        System.out.println("   항목 수:              " + calc.getCount());
        System.out.println("   합계:                " + calc.getSum());
        System.out.println("   최소값:              " + calc.getMin());
        System.out.println("   최대값:              " + calc.getMax());
        System.out.println("   평균:                " + calc.getMean());
        System.out.println("   표준 편차:            " + calc.getStandardDeviation());

    } // end main()

} // end SimpleStats