package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise9 {
    public static void main(String[] args) {
        int height;
        height = Integer.parseInt(JOptionPane.showInputDialog("Input the height"));

        for (int row = 1; row <= height; row++) {

            for (int i = 1; i <= height - row; i++) {
                System.out.print(" ");
            }

            for (int i = 1; i <= row; i++) {
                System.out.print(i);
            }
            for (int i = row-1; i >= 1; i--) {
                System.out.print(i);
            }

            System.out.println();
        }
    }

}
