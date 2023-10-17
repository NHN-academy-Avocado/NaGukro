package org.chapter.chapter2;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first nameand last name, separatedby a space.");
        String name = scanner.nextLine();
        int indexOfBlank = name.indexOf(" ");
        String s1 = name.substring(0,indexOfBlank);
        String s2 = name.substring(indexOfBlank, name.length());

        System.out.println("Your first nameis " + s1 + ", which has " +indexOfBlank + "characters");
        System.out.println("Your last nameis " + s2 + ", which has " + (name.length()-indexOfBlank-1) + "characters" );
    }
}
