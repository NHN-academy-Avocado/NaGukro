package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise2 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));
        for (int i = 1; i <= num; i++) {
            if (i%2==0) {
                System.out.println(i);
            }

        }
    }

}
