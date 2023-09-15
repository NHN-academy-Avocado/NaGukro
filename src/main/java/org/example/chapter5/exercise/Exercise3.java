package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise3 {

     public static void main(String[] args) {
        int a, b, c;
        a = Integer.parseInt(JOptionPane.showInputDialog("a변의 길이를 입력하세요"));
        b = Integer.parseInt(JOptionPane.showInputDialog("b변의 길이를 입력하세요"));
        c = Integer.parseInt(JOptionPane.showInputDialog("c변의 길이를 입력하세요"));
        int[] d = new int[] {a,b,c};

        //삼각형 객체 만들면서 삼각형이 될 수 있는지 sout
        Triangle triangle =new Triangle(d);

        if (a == b && b == c) {
            System.out.println("정삼각형입니다");
        }else if (a == b || b == c) {
            System.out.println("이등변삼각형입니다");
        } else {
            System.out.println("그냥 삼각형입니다");
        }

    }
}
