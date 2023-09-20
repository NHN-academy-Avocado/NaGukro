package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise5 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입렵하세요"));
        pi(num);
    }


    public static void pi(int num) {
        if (num == 1) {
            System.out.println(4);
        } else if (num >= 2) {
            double result = 4.0;
            for (int i = 1; i < num; i++) {
                result += (Math.pow(-1, i)) * (4.0 / ((2.0*i)+1.0));
            }
            System.out.println(result);
        } else {
            System.out.println("1보다 크거나 같은 수를 입력해주세요");
        }

    }
}
