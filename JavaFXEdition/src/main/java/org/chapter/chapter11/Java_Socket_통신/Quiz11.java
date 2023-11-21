package org.chapter.chapter11.Java_Socket_통신;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz11 {

    public static void main(String[] args) {
        int port = 1234; // 기본 포트

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 " + port + " 포트에서 대기 중입니다...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedInputStream input = new BufferedInputStream(clientSocket.getInputStream());
                 BufferedOutputStream output = new BufferedOutputStream(clientSocket.getOutputStream())) {

                System.out.println(
                        "클라이언트 " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort() +
                                " 가 연결되었습니다.");

                byte[] buffer = new byte[2048];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                    output.flush();
                }
            } catch (IOException e) {
                System.err.println("클라이언트 처리 오류: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
