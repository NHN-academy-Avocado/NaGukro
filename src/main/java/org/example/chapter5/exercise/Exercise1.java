package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise1 {
    public static void main(String[] args) {
        //Todo 5-1
         double g = Double.parseDouble(JOptionPane.showInputDialog("실수를 입력하세요"));
         if (g > 40) {
             System.out.println("extra strong liquor");
         } else if (g>20 && g<=40) {
             System.out.println("strong liquor");
         } else if (15 < g && g <=20) {
             System.out.println("liquor");
         } else if (12 <g && g<=15) {
             System.out.println("strong vine");
         } else if (10.5 < g && g <= 12) {
             System.out.println("normal vine");
         } else {
             System.out.println("light vine");
         }
    }
}
