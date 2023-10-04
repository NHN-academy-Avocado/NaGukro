package org.example.chapter8.Exercise;

class BankAccount {
    private String name;
    private String surname;
    private double balance;

    public BankAccount(String name, String surname, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public void applyInterest(double rate) {
        this.balance += (this.balance * rate / 100);
    }

    public boolean isNegative() {
        return this.balance < 0;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
