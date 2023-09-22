package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        print("test.txt");

    }

    public static void print(String filename) throws IOException {
        FileReader f = new FileReader(filename);
        BufferedReader in = new BufferedReader(f);
        String line = in.readLine();
        while (line.charAt(0) == ';' || line.charAt(0) == '/' || line.charAt(0) == '%') {
            String n = (line);
            System.out.println(n);

            line = in.readLine();
        }


    }
}
