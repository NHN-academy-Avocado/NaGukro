package org.chapter.exercise3;

/**
 * 모든 가능한 생일을 가진 사람을 찾기 위해
 * 무작위로 몇 명의 사람을 선택해야 할까요?
 * (윤년을 제외하고). 이 프로그램은 그 과정을 시뮬레이션합니다.
 */
public class Exercise7_3 {

    /**
     * 무작위로 사람을 선택하고 그들이 태어난 연중 날짜를 확인합니다.
     * 모든 365개의 가능한 생일 (윤년 제외)을 찾을 때까지 사람들을 선택합니다.
     * 그런 다음 조사한 사람의 수가 출력됩니다.
     */
    public static void main(String[] args) {

        boolean[] used;  // 지금까지 본 가능한 생일을 기록하기 위함.
        // used[i]의 true 값은 i번째 날에 생일인 사람이 발견되었음을 의미합니다.

        int count;       // 조사된 사람의 수.

        int birthdaysFound;   // 발견된 다른 생일의 수.

        used = new boolean[365];  // 처음에는 모든 항목이 false입니다.

        count = 0;

        birthdaysFound = 0;

        while (birthdaysFound < 365) {
            // 0부터 364까지 생일을 무작위로 선택합니다.
            // 생일이 아직 사용되지 않았다면, birthdaysFound에 1을 더합니다.
            int birthday;  // 선택된 생일.
            birthday = (int)(Math.random()*365);
            count++;
            if ( used[birthday] == false )
                birthdaysFound++;
            used[birthday] = true;
        }

        System.out.println(count + " 명의 사람들이 조사되었습니다.");

    }

} // end class 생일문제4
