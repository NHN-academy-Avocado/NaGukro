package org.example.chapter6.exercise;

import javax.swing.JOptionPane;

public class Exercise15 {
    public static void main(String[] args) {
        String sender = new String(JOptionPane.showInputDialog("발신자"));
        String receiver = new String(JOptionPane.showInputDialog("수신자"));
        String message = new String(JOptionPane.showInputDialog("메세지"));
        Message m = new Message(sender, receiver, message);
        m.eliminateVowels();
        m.eliminateBlank();

        System.out.println(m);
    }
}
