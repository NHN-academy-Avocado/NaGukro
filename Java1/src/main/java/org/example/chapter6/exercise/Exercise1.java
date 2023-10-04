package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise1 {
    public static void main(String[] args) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(JOptionPane.showInputDialog("수를 입력하세요"));
            if (smallest > input) {
                smallest = input;
            }
        }
        System.out.println(smallest);
    }
}
