package org.chapter.chapter11.Java_Socket_통신;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam04 {
    public static void main(String[] args) {
        int port = 1234;

        //서비스를 위한 port를 지정해 ServerSocket object를 생성한다.
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

            // tag::send[]
            socket.getOutputStream().write("Hello!".getBytes());
            socket.getOutputStream().flush();
            // end::send[]

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}