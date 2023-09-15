package org.example.chapter5;

public class BankAccount {
    private String name, surname;
    private double balance;

    public BankAccount(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void withdraw(double val) {
        if (val <= balance)
            balance -= val;
        else
            System.out.println("Not sufficient money for withdrawal");
    }

    public boolean sameOwner(BankAccount ba) {
        return this.name.equals(ba.name) &&
                this.surname.equals(ba.surname);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void transferTo (BankAccount ba, double val) {
        if (val <= this.balance) {
            this.withdraw(val);
            ba.deposit(val);
        } else
            System.out.println("It is not possible to withdraw " + val +
                    " Euro from account " + this);
    }

    public void transferFrom (BankAccount ba, double val) {
        if (val <= ba.balance) {
            ba.withdraw(val);
            this.deposit(val);
        } else
            System.out.println("It is not possible to withdraw " + val +
                    " Euro from account " + ba);
    }
    public void deposit(double val) {
        balance = balance + val;
    }
}
