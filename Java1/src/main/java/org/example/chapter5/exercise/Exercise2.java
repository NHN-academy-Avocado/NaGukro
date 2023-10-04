package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise2 {
    public static void main(String[] args) {
        int a, b, c;
        a = Integer.parseInt(JOptionPane.showInputDialog("a변의 길이를 입력하세요"));
        b = Integer.parseInt(JOptionPane.showInputDialog("b변의 길이를 입력하세요"));
        c = Integer.parseInt(JOptionPane.showInputDialog("c변의 길이를 입력하세요"));
        int[] x = {a, b, c};
        int pairs = 0;

        for (int component: x){
            int count = 0;
            for (int i = 0; i < x.length-1; i++) {
                if (component == x[i]) {
                    count++;
                }
            }
            if (count == 1) {
                pairs = 0;
            } else if (count == 2) {
                pairs = 1;
            }
        }


        if (pairs == 0) {
            System.out.println("it is irregular");
        } else if (pairs == 1) {
            System.out.println("it is symmetric");
        } else {
            System.out.println("it is regular");
        }
    }
}
