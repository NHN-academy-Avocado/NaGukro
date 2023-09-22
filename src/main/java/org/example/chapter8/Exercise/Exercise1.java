package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Exercise1 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
    }


    public String[] loadArray(InputStream is, int n) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader in = new BufferedReader(inputStreamReader);


        // Creation of the array
        String[] v = new String[n];
        // Loop to read the strings from the file into the array
        in = new BufferedReader(inputStreamReader);
        int i = 0;
        String line = in.readLine();
        while ((line != null) && (i < n)) {
            v[i] = line;
            line = in.readLine();
            i++;
        }
        inputStreamReader.close();
        return v;
    }

    public void saveArray(OutputStream os, String[] sa) throws IOException{
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
        PrintWriter out = new PrintWriter(outputStreamWriter);
        for (int i = 0; i < sa.length; i++)
            out.println(sa[i]);
        out.close();
        outputStreamWriter.close();
    }
}

