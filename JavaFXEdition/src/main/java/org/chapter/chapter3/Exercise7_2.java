package org.chapter.chapter3;

/**
 * 이 프로그램은 365명의 사람을 무작위로 선택하고
 * 그들 사이에 얼마나 많은 다른 생일이 있는지 찾는 시뮬레이션을 합니다.
 */
public class Exercise7_2 {

    /**
     * 무작위로 사람을 선택하고 그들이 태어난 연중 날짜를 확인합니다.
     * 365명의 사람들 중에서 발견된 다른 날짜의 수를 세고 출력합니다.
     */
    public static void main(String[] args) {

        boolean used[];  // used[i]는 i번째 날에 태어난 사람이 발견되면 true입니다.

        used = new boolean[365];  // 처음에는 모든 항목이 false입니다.

      /* 365일을 무작위로 선택하고, 해당 일에 대한 배열의 항목, used를
         true로 설정하여 그 날을 표시합니다. (값이 이미 true이면 상관 없습니다.
         생일이 얼마나 많이 발생하는지는 관심이 없습니다. 생일이 발생했는지 여부만 관심이 있습니다.)
      */

        int i;
        for (i = 0; i < 365; i++) {
            int birthday;  // 선택된 생일.
            birthday = (int)(Math.random()*365);
            used[birthday] = true;
        }

      /* 이제, used 배열에서 true인 항목이 몇 개인지 계산합니다.
         이것은 발견된 다른 생일의 수입니다.
      */

        int count = 0;
        int day;

        for (day = 0; day < 365; day++) {
            // 이 날이 생일로 발생했다면 그것을 계산합니다.
            if (used[day] == true)
                count++;
        }

        System.out.println("365명의 사람들 중에서 " + count + " 개의 다른 생일이 있었습니다.");

    }


} // end class 생일문제3
