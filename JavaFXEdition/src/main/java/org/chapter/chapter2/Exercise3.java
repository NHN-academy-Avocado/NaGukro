package org.chapter.chapter2;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        scanner.close();

        System.out.print("Hello, ");
        System.out.print(name.toUpperCase());
        System.out.println(", nice to meet you!");
    }
}
