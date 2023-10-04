package org.example.chapter4.exercise;

public class BankAccount {
    private String name, surname;
    private double balance;

    public BankAccount(String n, String s) {
        name = n;  surname = s;  balance = 0;
    }

    public void deposit(double val) {
        balance = balance + val;
    }

    public void withdraw(double val) {
        balance = balance - val;
    }

    public String toString() {
        return "{ Owner: " + name + " " + surname +
                " - Balance: Euro " + balance + " }";
    }
}
