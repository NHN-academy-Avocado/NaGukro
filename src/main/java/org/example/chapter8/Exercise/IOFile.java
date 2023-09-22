package org.example.chapter8.Exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFile {
    private String filename;

    public IOFile(String filename) {
        this.filename = filename;
    }

    public int countLines() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }

    // Method to write the content of the file to an OutputStream
    //쓰기
    public void write(OutputStream os) throws IOException {
        try (InputStream is = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }


    //터미널에 찍기
    public void print() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    //파일 복사
    public void copy(String newFilename) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        PrintWriter printWriter = new PrintWriter(new FileWriter(newFilename));
        String s;
        while ((s = bufferedReader.readLine())!=null) {
            printWriter.println(s);
        }
        printWriter.close();
        bufferedReader.close();

    }

    //파일 삭제
    public void delete() throws IOException {
        Path path = Paths.get(filename);

        Files.delete(path);
    }

    public static void main(String[] args) throws IOException {
        IOFile file = new IOFile("test.txt");


        System.out.println("파일의 줄 수: " + file.countLines());

        file.print();

        file.copy("test_copy.txt");

        // Write the content to an OutputStream
        OutputStream os = new FileOutputStream("test_output.txt");

        file.write(os);


        //원본파일 삭제
        // file.delete();


    }

}
