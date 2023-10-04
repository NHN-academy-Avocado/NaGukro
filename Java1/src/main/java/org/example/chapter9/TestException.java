package org.example.chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestException {
    public static void main(String[] args) throws MyException, IOException {
        int min = 10, max = 30;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a number between " + min +
                " and " + max + " included");
        int value = Integer.parseInt(br.readLine());
        if (value < min || value > max)
            throw new MyException();
        System.out.println("The value is in the allowed interval");
    }

}