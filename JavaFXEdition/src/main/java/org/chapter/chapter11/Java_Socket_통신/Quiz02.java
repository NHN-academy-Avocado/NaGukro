package org.chapter.chapter11.Java_Socket_통신;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Quiz02 {
    public static void main(String[] args) {
        int startPort = 0;
        int endPort = 65535;

        if (args.length < 2) {
            System.err.println("검색할 포트 범위 지정이 필요합니다.");
        }
        Scanner scanner = new Scanner(System.in);


        try {
            startPort =
                    scanner.nextInt();
            endPort = scanner.nextInt();

            if (endPort < startPort) {
                int temp = startPort;
                startPort = endPort;
                endPort = temp;
            }
        } catch (NumberFormatException e) {
            System.err.println("포트 올바르지 않습니다.");
        }

        for (int port = startPort; port < endPort; port++) {
            // try-with-resources
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("Port " + port + " 열려 있습니다.");
            } catch (IOException ignore) {
            }
        }
    }
}