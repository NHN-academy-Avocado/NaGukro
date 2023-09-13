package org.example.chapter3.exercise;

public class Message {

    private String callNumber;

    private String senderNumber = "010123124551";

    private MessageText messageText;

    public Message(String callNumber, MessageText messageText) {
        this.callNumber = callNumber;
        this.messageText = messageText;
    }

    public Message(MessageText messageText) {
        this.messageText = messageText;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
    public void printMessage() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Message{" +
                "callNumber='" + callNumber + '\'' +
                ", senderNumber='" + senderNumber + '\'' +
                ", messageText=" + messageText +
                '}';
    }
}
