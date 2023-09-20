package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise11 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));
        if (isprime(num)) {
            System.out.println("소수입니다.");
        } else {
            System.out.println("소수가 아닙니다.");
        }

    }

    public static boolean isprime(int number) {
        int count =0;
        for (int i = 2; i <= number; i++) {
            if ((number%i)==0) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
