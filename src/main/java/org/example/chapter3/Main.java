package org.example.chapter3;

public class Main {
    public static void main(String[] args) {
//        printGtreeting();
//        printPersonalGreeting("나", "국로");
//        printInformalGreeting("나국로");
        System.out.println(personalGreeting("국로", "나"));
    }

    public static void printGtreeting(){
        System.out.println("Good morning!");
    }
    public static void printPersonalGreeting(String firstName, String lastName) {
        System.out.print("Good morning ");
        System.out.print(firstName);
        System.out.print(" ");
        System.out.print(lastName);
        System.out.println("!");
    }

    public static void printInformalGreeting (String name) {
        System.out.println("Ciao " + name + "!");
    }

    public static String personalGreeting(String firstName, String lastName) {
        return "Good morning " + firstName + " " + lastName + "!";
    }
}
