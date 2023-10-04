package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        FileWriter f = new FileWriter("matrix.txt");
        PrintWriter out = new PrintWriter(f);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("몇 단까지 입력할까요?");
        int num = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (i * j <= num) {
                }
                out.print(i * j + " ");
                out.print((j==num)? "\n" : "");
            }
        }
        out.close();
        f.close();
    }
}
