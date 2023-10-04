package org.example.chapter8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        OutputStream os = System.out;

        write(os);

    }

    public static void write(OutputStream os) throws IOException {
        try (InputStream is = new FileInputStream("test.txt")) {
            byte[] buffer = new byte[2];
            int count = 0;
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                count++;
                System.out.println("반복 횟수" +count);
            }
        }
    }
}
