package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise10 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("수를 입력하세요"));

        for (int i = 1; i <= num; i++) {
            Exercise3.factorial(i);
        }
    }
}
