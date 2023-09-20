package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise14 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요"));

        //isprime 안쓰는데?
        int i =2;
        while (num>1) {
            if (num % i ==0) {
                System.out.println(i);
                num/=i;
            } else i++;
        }
    }
}
