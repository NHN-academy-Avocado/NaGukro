package org.chapter.exercise3;

public class Exercise3 {

    public static void main(String[] args) {

        double firstNum;    // 표현식의 첫 번째 숫자.
        double secondNum;   // 표현식의 두 번째 숫자.
        char operator;      // 표현식의 연산자.
        double value;       // 표현식의 값.

        System.out.println("2 + 2 또는 34.2 * 7.81과 같은 표현식을 입력하십시오");
        System.out.println("+, -, *, / 중 하나의 연산자를 사용하십시오.");
        System.out.println("종료하려면 0을 입력하십시오.");
        System.out.println();

        while (true) {

            /* 사용자의 입력을 받아 첫 번째 숫자가 0이면 프로그램 종료. */

            System.out.print("? ");
            firstNum = TextIO.getDouble();
            if (firstNum == 0)
                break;
            operator = TextIO.getChar();
            secondNum = TextIO.getlnDouble();

            /* 표현식의 값을 계산한다. */

            switch (operator) {
                case '+':
                    value = firstNum + secondNum;
                    break;
                case '-':
                    value = firstNum - secondNum;
                    break;
                case '*':
                    value = firstNum * secondNum;
                    break;
                case '/':
                    value = firstNum / secondNum;
                    break;
                default:
                    System.out.println("알 수 없는 연산자: " + operator);
                    continue;  // 반복문의 처음으로 돌아갑니다!
            }


            /* 값을 표시한다. */

            System.out.println("값은 " + value + " 입니다.");
            System.out.println();

        } // end while

        System.out.println("안녕히 가십시오");

    }  // end main()

}  // end class SimpleCalculator

