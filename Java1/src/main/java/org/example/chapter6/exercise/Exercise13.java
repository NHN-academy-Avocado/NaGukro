package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise13 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));
        int i = 2;
        while (num > 0) {
            if (Exercise11.isprime(i)) {
                System.out.println(i);
                num--;
            }
            i++;
        }

    }
}

