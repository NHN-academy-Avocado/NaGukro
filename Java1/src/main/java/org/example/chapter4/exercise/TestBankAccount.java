package org.example.chapter4.exercise;

public class TestBankAccount {
    public static void main (String[] args) {
        BankAccount ba = new BankAccount("Mario", "Rossi");
        System.out.println("Before the operations: " + ba);
        ba.deposit(1000);
        ba.withdraw(100);
        System.out.println("After the operations: " + ba);
        System.out.println(lastCharacter("asd"));
    }

    public static char lastCharacter(String s) {
        //Todo 4-10
        char a = s.charAt(s.length()-1);
        return a;
    }

}