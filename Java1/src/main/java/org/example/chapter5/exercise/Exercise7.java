package org.example.chapter5.exercise;

import javax.swing.JOptionPane;

public class Exercise7 {


    public static void main(String[] args) {
        //Todo 5-7
        Date a = new Date(JOptionPane.showInputDialog("첫번째 날짜를 입력하세요 ex)20021018 (2002년 10월 18일 이면)"));
        Date b = new Date(JOptionPane.showInputDialog("두번째 날짜를 입력하세요 ex)20021018 (2002년 10월 18일 이면)"));
//
//
        isdateeuql(a, b);
        isdateprocede(a, b);
        isleaf(a);
        outputnextday(a);
    }

    private static void outputnextday(Date a) {
        Date date = new Date(a);
        System.out.println(date);
    }


    public static boolean isdateeuql(Date date1, Date date2) {
        if (date1.getDate().equals(date2.getDate())) {
            return true;
        } else {
            return false;
        }
    }

    public static void isleaf(Date date) {
        int year = date.getYear();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("윤년입니다.");
        } else {
            System.out.println("평년입니다.");
        }
    }

    private static void isdateprocede(Date date1, Date date2) {
        if (date1.compareTo(date2) == -1) {
            System.out.println("date1의 날짜가 더 이전입니다");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("날짜가 같습니다.");
        } else {
            System.out.println("date2의 날짜가 더 이전입니다.");
        }

    }


}
