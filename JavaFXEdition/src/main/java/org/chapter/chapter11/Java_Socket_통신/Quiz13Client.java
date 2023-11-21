package org.chapter.chapter11.Java_Socket_통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

public class Quiz13Client {

    public static void main(String[] args) {
        String clientId = args.length > 0 ? args[0] : UUID.randomUUID().toString();
        String host = args.length > 1 ? args[1] : "localhost";
        int port = args.length > 2 ? Integer.parseInt(args[2]) : 1234;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            out.println(clientId);

            new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    System.out.println("서버로부터의 응답을 읽는 동안 오류가 발생했습니다: " + e.getMessage());
                }
            }).start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if ("!exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
            }
        } catch (IOException e) {
            System.err.println("클라이언트 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
