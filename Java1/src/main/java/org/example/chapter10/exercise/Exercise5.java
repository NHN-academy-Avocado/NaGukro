package org.example.chapter10.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test1.txt"))) {
            int count = countOne(br);
            System.out.println("1 반복 횟수 : " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countOne(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) {
            return 0;
        } else {
            int number = Integer.parseInt(line);
            return ((number == 1) ? 1 : 0) + countOne(br);
        }
    }

}
