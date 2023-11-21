package org.chapter.chapter11.Java_Socket_통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Quiz13 {

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 " + port + " 포트에서 대기 중입니다...");

            Map<String, Socket> clientSockets = Collections.synchronizedMap(new HashMap<>());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket, clientSockets)).start();
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final Map<String, Socket> clientSockets;
        private String clientId;

        public ClientHandler(Socket socket, Map<String, Socket> clientSockets) {
            this.clientSocket = socket;
            this.clientSockets = clientSockets;
        }

        @Override
        public void run() {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {

                clientId = input.readLine();
                clientSockets.put(clientId, clientSocket);

                System.out.println(clientId + " 클라이언트가 연결되었습니다.");

                String message;
                while ((message = input.readLine()) != null) {
                    if (message.startsWith("@")) {
                        int spaceIndex = message.indexOf(' ');
                        String targetClientId = message.substring(1, spaceIndex);
                        String targetMessage = message.substring(spaceIndex + 1);
                        sendMessageToClient(targetClientId, targetMessage);
                    } else if (message.equals("!list")) {
                        output.println(clientSockets.keySet());
                    }
                }
            } catch (IOException e) {
                System.err.println(clientId + " 클라이언트 처리 오류: " + e.getMessage());
                e.printStackTrace();
            } finally {
                clientSockets.remove(clientId);
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void sendMessageToClient(String targetClientId, String message) {
            Socket targetSocket = clientSockets.get(targetClientId);
            if (targetSocket != null) {
                try {
                    PrintWriter targetOutput = new PrintWriter(targetSocket.getOutputStream(), true);
                    targetOutput.println(clientId + ": " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
