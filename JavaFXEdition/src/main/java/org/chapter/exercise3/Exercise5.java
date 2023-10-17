package org.chapter.exercise3;

public class Exercise5 {
    public static void main( String[] args ) {

        /* 파일을 읽기 위해 열기; 열 수 없는 경우 프로그램 종료 */

        try {
            TextIO.readFile("sales.dat");
        }
        catch (IllegalArgumentException e) {
            System.out.println("\"sales.dat\" 파일을 읽기 위해 열 수 없습니다!");
            System.out.println("프로그램을 실행하기 전에 파일이 존재하는지 확인하십시오.");
            System.exit(1);  // 프로그램 종료.
        }

        /* 파일을 읽으며 총 판매량과 누락된 데이터를 추적한다. */

        double salesTotal;  // 지금까지 본 모든 판매 실적의 합계.
        int missingCount;   // 데이터가 누락된 도시의 수.

        salesTotal = 0;
        missingCount = 0;

        while ( ! TextIO.eof() ) {  // 데이터의 한 줄을 처리한다.

            char ch;  // 도시의 이름을 읽어 넘어가기 위한 변수.
            String dataString;  // 도시 이름 이후의 줄 내용.
            double sales;  // 도시의 판매 실적.

            do {  // ':'까지의 문자를 읽어 넘긴다.
                ch = TextIO.getChar();
            } while (ch != ':');

            dataString = TextIO.getln();  // 줄의 나머지 부분을 얻는다.

            try {
                sales = Double.parseDouble(dataString);
                salesTotal += sales;  // 변환 실패시 이 부분은 생략된다.
            }
            catch (NumberFormatException e) {
                // dataString은 숫자가 아니므로 누락된 데이터로 간주된다.
                // 누락된 데이터 수에 1을 더한다.
                missingCount++;
            }

        } // end while

        /* 결과를 보고한다. */

        System.out.printf("모든 도시에서 기록된 총 판매량: $%1.2f\n\n", salesTotal);
        if (missingCount == 0)
            System.out.println("모든 도시에서 데이터를 받았습니다.");
        else if (missingCount == 1)
            System.out.println("1개 도시에서 데이터가 누락되었습니다.");
        else
            System.out.printf("%d개 도시에서 데이터가 누락되었습니다.\n", missingCount);

    } // end main()

} // end class 판매실적
