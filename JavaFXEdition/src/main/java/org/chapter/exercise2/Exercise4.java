package org.chapter.exercise2;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int quarter = scanner.nextInt();
        int dime = scanner.nextInt();
        int nickel = scanner.nextInt();
        int penny = scanner.nextInt();

        scanner.close();
        int total = 25*quarter + 10*dime + 5*nickel + penny;

        System.out.println("잔돈은 " + total%100 + "입니다.");


    }
}
