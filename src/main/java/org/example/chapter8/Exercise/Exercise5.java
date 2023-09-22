package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args) throws IOException {
        highestStudentScore("score.txt");
    }

    public static void highestStudentScore(String filename) throws IOException {
        FileReader f = new FileReader(filename);
        BufferedReader in = new BufferedReader(f);
        //없어도 됌 어디까지 돌릴건지
        int n = 0;
        String line = in.readLine();
        while (line != null) {
            n++;
            line = in.readLine();
        }
        f.close();
        String[] v = new String[n];
        f = new FileReader(filename);
        in = new BufferedReader(f);
        int i = 0;
        double max = 0;
        String highestPerson="";
        line = in.readLine();
        while ((line != null) && (i < n)) {
            v[i] = line;
            String[] s = line.split(" ");
            String[] s1 = Arrays.copyOfRange(s, 1, s.length);
            int[] nums = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
            double avg = Arrays.stream(nums).sum()/nums.length;
            if (avg>max) {
                max = avg;
                highestPerson= s[0];
            }
            line = in.readLine();
            i++;
        }
        f.close();

        System.out.println(highestPerson);
    }
}
