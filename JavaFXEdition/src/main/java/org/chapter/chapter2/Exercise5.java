package org.chapter.chapter2;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEggs = scanner.nextInt();
        System.out.println("Your number of eggsis " + numberOfEggs/144 + " gross, " + numberOfEggs%144/12 + " dozen,and "+ numberOfEggs%144%12%12);
    }
}
