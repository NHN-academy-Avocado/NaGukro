package org.example.chapter3.exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Todo 3-2
        Scanner scanner = new Scanner(System.in);

        System.out.println("첫번째 책의 제목과 저자를 입력하세요");
        Book book1 = new Book(scanner.next(), scanner.next());

        System.out.println("두번째 책의 제목과 저자를 입력하세요");
        Book book2 = new Book(scanner.next(), scanner.next());

        book1.printBookPrice();
        book2.printBookPrice();
        book1.windowBook();


        System.out.println("첫번째 책의 가격을 입력하세요");
        book1.setPrice(scanner.nextInt());

        System.out.println(book1);

        scanner.close();

    }
}
