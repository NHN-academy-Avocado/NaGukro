package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise7 {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("문자열을 입력하세요");
        char c = JOptionPane.showInputDialog("문자를 입력하세요").charAt(0);

        subsequence(s,c);



    }

    private static void subsequence(String s, char c) {
        char bit;
        int cont = 0;
        int maxlen =0;
        for (int i = 0; i < s.length(); i++) {
            bit = s.charAt(i);
            if (bit == c) {
                cont++;
                if (cont > maxlen)
                    maxlen = cont;
            }else
                cont = 0;
        }
    }

}
