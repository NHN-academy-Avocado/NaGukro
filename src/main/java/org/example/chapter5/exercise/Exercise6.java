package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise6 {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("입력하세요");

        String line = s.substring(0,5);
        char last = s.charAt(s.length()-1);
        if (line.equals("vocal")) {
            System.out.println("MAYBE");
        } else if (last == 'a' || last == 'b' || last == 'c') {
            System.out.println("YES");
        } else if (last == 'e' || last == 'o') {
            System.out.println("NO");
        } else {
            System.out.println("DON'T KNOW");
        }
    }
}
