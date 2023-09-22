package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class HandleBAs {
    private String filename;
    private ArrayList<BankAccount> accounts;

    public HandleBAs(String filename) throws IOException {
        this.filename = filename;
        this.accounts = new ArrayList<>();
        loadAccounts();
    }

    private void loadAccounts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String name;
        String surname;
        double balance;

        while ((name = reader.readLine()) != null &&
                (surname = reader.readLine()) != null &&
                (balance = Double.parseDouble(reader.readLine())) != -1) {
            accounts.add(new BankAccount(name, surname, balance));
        }

    }

    public void interests(double rate) {
        for (BankAccount account : accounts) {
            account.applyInterest(rate);
        }
    }

    public void printNegative() {
        for (BankAccount account : accounts) {
            //balance가 음수이면 반환
            if (account.isNegative()) {
                System.out.println(account);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        HandleBAs handleBAs = new HandleBAs("bank_accounts.txt");

        handleBAs.interests(3.5);
        System.out.println("마이너스 계좌:");
        handleBAs.printNegative();
    }
}

