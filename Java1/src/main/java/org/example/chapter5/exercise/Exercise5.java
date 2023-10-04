package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise5 {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("\"a*x^2+b*x+c=0\" a를 입력하세요"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("\"a*x^2+b*x+c=0\" b를 입력하세요"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("\"a*x^2+b*x+c=0\" c를 입력하세요"));

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("방정식은 2개의 값을 가집니다" + root1 + " 와 " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("방정식은 1개의 값을 가집니다" + root);
        } else {
            System.out.println("방정식의 해가 없습니다.");
        }
    }



}
