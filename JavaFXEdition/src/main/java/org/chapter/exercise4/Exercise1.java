package org.chapter.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printCapitalized(bufferedReader.readLine());

    }

    static void printCapitalized(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");

        int n = stringTokenizer.countTokens();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String string = stringTokenizer.nextToken();
            if (Character.isLetter(string.charAt(0))) {
                string = string.substring(0, 1).toUpperCase() + string.substring(1);
            }

            stringBuilder.append(string);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }
}
