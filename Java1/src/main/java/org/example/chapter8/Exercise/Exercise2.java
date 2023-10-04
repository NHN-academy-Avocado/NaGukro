package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Exercise2 {
    public static void main(String[] args) throws IOException {

        System.out.println(readIntegerAndOupputAvg());
    }

    public static double readIntegerAndOupputAvg () throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("평균을 구할 숫자를 입력해주세요 :");
        int count=1;
        int num = Integer.parseInt(bufferedReader.readLine());
        int result=0;

        while (num!=0) {
            result += num;
            count++;
            num = Integer.parseInt(bufferedReader.readLine());
        }

        return  ( (double) result / (count-1));


    }
}
