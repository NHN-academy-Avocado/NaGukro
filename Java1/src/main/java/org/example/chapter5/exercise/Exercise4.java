package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise4 {
    public static void main(String[] args) {
        int a, b, c;
        a = Integer.parseInt(JOptionPane.showInputDialog("a변의 길이를 입력하세요"));
        b = Integer.parseInt(JOptionPane.showInputDialog("b변의 길이를 입력하세요"));
        c = Integer.parseInt(JOptionPane.showInputDialog("c변의 길이를 입력하세요"));
        int[] d = new int[] {a,b,c};

        //삼각형 객체 만들면서 삼각형이 될 수 있는지 sout
        Triangle triangle =new Triangle(d);
//        System.out.println(triangle.getTop());
//        System.out.println(triangle.getMiddle());
//        System.out.println(triangle.getBottom());
        //각 변의 길이 반환
        triangle.retuenLength();
        //둘레 구하기
        triangle.perimeter();
        //면접 구하기
        triangle.area();
        //삼각형의 유형 반환
        triangle.type();


    }
}
