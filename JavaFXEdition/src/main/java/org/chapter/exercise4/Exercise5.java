package org.chapter.exercise4;

/**
 * This class defines several public static member variables of
 * type ArrayProcessor that process arrays in various ways.  It
 * also defines a function that can create ArrayProcessors for
 * counting occurrences of values in an array.  (Note that this
 * program depends on interface ArrayProcessor.)
 */
public class Exercise5 {

    /**
     * 이 함수는 주어진 값이 배열의 중복 횟수를 세는 ArrayProcessor를 반환합니다.
     * 매개변수는 세어야 할 값입니다.
     */
    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value)
                    count++;
            }
            return count;
        };
    }


    /**
     * 배열의 최대값을 계산하고 반환하는 ArrayProcessor입니다. (배열은 길이가 적어도 1이어야 합니다.)
     */
    public static final ArrayProcessor maxer = array -> {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    };


    /**
     * 배열의 최소값을 계산하고 반환하는 ArrayProcessor입니다. (배열은 길이가 적어도 1이어야 합니다.)
     */
    public static final ArrayProcessor miner = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    };


    /**
     * 배열의 합계를 계산하고 반환하는 ArrayProcessor입니다. (배열은 길이가 적어도 1이어야 합니다.)
     */
    public static final ArrayProcessor sumer = array -> {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    };


    /**
     * 배열의 값들의 평균을 계산하고 반환하는 ArrayProcessor입니다. (배열은 길이가 적어도 1이어야 합니다.)
     */
    public static final ArrayProcessor averager =
            array -> sumer.apply(array) / array.length;



    //---------------------------------------------------------------------------------------------------

    /**
     * 이 클래스의 (다른) 공개 멤버를 테스트하기 위한 main() 루틴입니다.
     */
    public static void main(String[] args) {

        double[] firstList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        double[] secondList = { 17.0, 3.14, 17.0, -3.4, 17.0, 42.0, 29.2, 3.14 };

        System.out.println("첫 번째 목록의 합계 (예상 결과: 55): "
                + sumer.apply(firstList) );
        System.out.println("첫 번째 목록의 평균 (예상 결과: 5.5): "
                + averager.apply(firstList) );
        System.out.println("두 번째 목록의 최소값 (예상 결과: -3.4): "
                + miner.apply(secondList) );
        System.out.println("두 번째 목록의 최대값 (예상 결과: 42.0): "
                + maxer.apply(secondList) );

        System.out.println();

        System.out.println("두 번째 목록에서 17.0의 개수 (예상 결과: 3): "
                + counter(17.0).apply(secondList) );
        System.out.println("두 번째 목록에서 20.0의 개수 (예상 결과: 0): "
                + counter(20.0).apply(secondList) );
        System.out.println("첫 번째 목록에서 5.0의 개수 (예상 결과: 1): "
                + counter(5.0).apply(firstList) );

    }


} // end class LambdaTest
