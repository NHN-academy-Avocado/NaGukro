package org.example.chapter3.exercise;

import java.util.Scanner;

public class MessageTextTest {

    //Todo 3-3,3-4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    //Todo 3-5

        System.out.println("메세지의 코드와 완전한 메세지를 입력해주세요");
        MessageText messageText = new MessageText(scanner.next(), scanner.next());

        System.out.println("수신자의 전화번호를 입력해주세요");
        Message message = new Message(scanner.next(), messageText);

        message.printMessage();

//        System.out.println(messageText.getCode());
//        System.out.println(messageText.getMessage());

        readScanner(scanner);

    }

    //Todo 3-6
    public static void readScanner(Scanner scanner) {
        System.out.println("메세지의 코드와 완전한 메세지를 입력해주세요");
        MessageText messageText = new MessageText(scanner.next(), scanner.next());

        System.out.println("수신자의 전화번호를 입력해주세요");
        Message message = new Message(scanner.next(), messageText);
        System.out.println(message);
    }
}
