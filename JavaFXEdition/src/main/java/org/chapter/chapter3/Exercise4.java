package org.chapter.chapter3;

public class Exercise4 {
    public static void main(String[] args) {

        String line;    // 사용자가 입력한 텍스트 한 줄.
        int i;          // line에서의 위치, 0부터 line.length() - 1까지.
        char ch;        // line의 문자 중 하나.
        boolean didCR;  // 이전 출력이 캐리지 리턴이었는지 여부.

        System.out.println("텍스트 한 줄을 입력하십시오.");
        System.out.print("? ");
        line = TextIO.getln();

        System.out.println();
        didCR = true;

        for ( i = 0;  i < line.length();  i++ ) {
            ch = line.charAt(i);
            if ( Character.isLetter(ch) ) {
                System.out.print(ch);
                didCR = false;
            }
            else {
                if ( didCR == false ) {
                    System.out.println();
                    didCR = true;
                }
            }
        }

        System.out.println();  // 끝에 적어도 하나의 캐리지 리턴이 있도록 합니다.

    }

}
