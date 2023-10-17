package org.chapter.chapter2;

public class Exercise2 {
    public static void main(String[] args) {
        int 주사위1 = (int)(Math.random() * 6) + 1;
        int 주사위2 = (int)(Math.random() * 6) + 1;

        System.out.print("첫 번째 주사위의 결과는 ");
        System.out.println(주사위1);
        System.out.print("두 번째 주사위의 결과는 ");
        System.out.println(주사위2);
        System.out.print("총합은 ");
        System.out.println(주사위1 + 주사위2);
    }
}
