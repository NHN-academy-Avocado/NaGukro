package org.chapter.chapter5.exercise2;

/*
 * StatCalc 클래스의 객체는 숫자 집합에 대한 여러 가지 간단한 통계를 계산하는 데 사용될 수 있습니다.
 * 숫자는 enter(double) 메서드를 사용하여 데이터 집합에 입력됩니다.
 * 다음과 같은 통계 정보를 반환하는 메서드가 제공됩니다.
 * 입력된 숫자 집합에 대해: 항목 수, 항목 합계, 평균, 표준 편차, 최대값 및 최소값.
 */
public class StatCalc {

    private int count;         // 입력된 숫자의 수.
    private double sum;        // 입력된 모든 항목의 합계.
    private double squareSum;  // 모든 항목의 제곱의 합계.
    private double max = Double.NEGATIVE_INFINITY;  // 본 적 있는 가장 큰 항목.
    private double min = Double.POSITIVE_INFINITY;  // 본 적 있는 가장 작은 항목.

    /**
     * 데이터 집합에 숫자를 추가합니다. 이 메서드를 사용하여 추가된 모든 숫자에 대한 통계가 계산됩니다.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num * num;
        if (num > max)          // 새로운 최대값이 있음.
            max = num;
        if (num < min)          // 새로운 최소값이 있음.
            min = num;
    }

    /**
     * 데이터 집합에 추가된 항목 수를 반환합니다.
     */
    public int getCount() {
        return count;
    }

    /**
     * 입력된 모든 숫자의 합계를 반환합니다.
     */
    public double getSum() {
        return sum;
    }

    /**
     * 입력된 모든 항목의 평균을 반환합니다. 숫자가 입력되지 않은 경우 반환값은 Double.NaN입니다.
     */
    public double getMean() {
        return sum / count;
    }

    /**
     * 입력된 모든 항목의 표준 편차를 반환합니다. 숫자가 입력되지 않은 경우 반환값은 Double.NaN입니다.
     */
    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

    /**
     * 입력된 항목 중 가장 작은 항목을 반환합니다.
     * 숫자가 입력되지 않은 경우 반환값은 무한대(Infinity)입니다.
     */
    public double getMin() {
        return min;
    }

    /**
     * 입력된 항목 중 가장 큰 항목을 반환합니다.
     * 숫자가 입력되지 않은 경우 반환값은 음의 무한대(Infinity)입니다.
     */
    public double getMax() {
        return max;
    }

}  // StatCalc 클래스 끝
