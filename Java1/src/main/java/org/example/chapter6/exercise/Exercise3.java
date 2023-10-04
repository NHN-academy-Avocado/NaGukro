package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise3 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));

        factorial(num);
    }

    public static void factorial(int n) {
        int i, fact = 1;

        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println(fact);


    }
}
