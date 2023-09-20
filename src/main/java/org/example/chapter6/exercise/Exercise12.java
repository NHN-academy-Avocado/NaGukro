package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise12 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));
        for (int i = 2; i <= num; i++) {
            boolean isprime = Exercise11.isprime(i);
            if (isprime) {
                System.out.println(i);
            }
        }
    }


}
