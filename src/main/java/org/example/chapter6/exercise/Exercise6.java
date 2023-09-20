package org.example.chapter6.exercise;


import javax.swing.JOptionPane;

public class Exercise6 {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("문자를 입력해주세요");
        int a = Integer.parseInt(JOptionPane.showInputDialog("decode할 숫자를 압력해주세요"));
        DecodedData decodedData = new DecodedData(s,a);
        decodedData.print();

    }

}
