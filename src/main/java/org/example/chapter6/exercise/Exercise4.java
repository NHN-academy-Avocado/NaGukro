package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise4 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("몇 개의 숫자를 입력할까요?"));
        int plus = 0;
        int minus = 0;

        for (int i = 0; i < num; i++) {
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("수를 입력해주세요"));
            if (num1 > 0) {
                plus = plus + num1;
            } else {
                minus = minus + num1;
            }
        }
        System.out.println("양의 정수의 합" + plus);
        System.out.println("음의 정수의 합" + minus);
    }


}
