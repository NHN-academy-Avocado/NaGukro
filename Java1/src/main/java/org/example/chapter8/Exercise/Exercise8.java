package org.example.chapter8.Exercise;

import static org.example.chapter7.exercise.Apartment.readFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.example.chapter7.exercise.Apartment;

public class Exercise8 {
    public static void main(String[] args) throws IOException {
        Apartment apt = new Apartment(100, "광주광역시 지상동");
        apt.resetPeoplelist();

        apt.addPerson("김");
        apt.addPerson("이");
        apt.saveToFile("apartment_data.txt");

        BufferedReader reader = new BufferedReader(new FileReader("apartment_data.txt"));
            //여기서 터지는데 원래는 사람들의 이름이 비어있는지 비교해서 사람을 추가했는데. 파일에서는 객체가 이미 비어 있어 있는 걸로 나옴
            Apartment aptFromFile = readFromFile(reader);
            System.out.println("Apartment information from file: " + aptFromFile);


    }
}