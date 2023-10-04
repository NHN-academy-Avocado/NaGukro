package org.example.chapter9;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise7 {

    public static void main(String[] args) {
        // Test the methods
        System.out.println("File Exists: " + Exercise7.fileExists("test.txt")); // Replace with actual filename
        System.out.println("Is Integer: " + Exercise7.isInt("123"));
        System.out.println("Is Double: " + Exercise7.isDouble("123.45"));
    }


    //파일 존재
    public static boolean fileExists(String filename) {
        return Files.exists(Paths.get(filename));
    }

    //정수인지
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //실수인지
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
