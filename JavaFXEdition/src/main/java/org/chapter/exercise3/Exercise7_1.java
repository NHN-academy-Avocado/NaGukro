package org.chapter.exercise3;

public class Exercise7_1 {

    /**
     * 무작위로 사람을 선택하고 그들이 태어난 연중 날짜를 확인합니다.
     * 만약 해당 날짜에 태어난 사람이 세 번째라면 멈추고,
     * 검사한 사람 수를 출력합니다.
     */
    public static void main(String[] args) {

        int[] numFound;  // numFound[i]는 연중 i번째 날에 생일인 사람의 수를 나타냅니다.

        int count;       // 검사된 사람 수.

        numFound = new int[365];  // 처음에는 모든 항목이 0입니다.

        count = 0;

        while (true) {
            // 0부터 364까지 무작위로 생일을 선택합니다.
            // 동일한 생일이 이미 두 번 확인되었다면 중지합니다.
            // 그렇지 않으면 해당 생일을 가진 사람을 찾았다는 기록으로
            // numFound 배열의 해당 항목에 1을 더합니다.
            int birthday;  // 선택된 생일.
            birthday = (int) (Math.random() * 365);
            count++;
            if (numFound[birthday] == 2) {
                break;
            }
            numFound[birthday]++;
        }

        System.out.println(count + " 번의 시도로 같은 생일을 가진 세 사람을 찾았습니다.");

    }


} // end class 생일문제2
