package org.example.chapter6.exercise;

public class Message {
    private String sender;
    private String receiver;
    private String message;

    public Message(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void switchwith() {
        String s1 = sender;
        String r1 = receiver;
        this.sender = r1;
        this.receiver = s1;
    }

    public void eliminateBlank() {
        message = message.trim();
        message = message.replaceAll("\\s+", " ");
    }

    public void eliminateVowels() {
        String[] replace = {"a", "e", "i", "o", "u"};
        String answer;
        for (int i = 0; i < replace.length; i++) {
            if (message.contains(replace[i])) {
                answer = message.replaceAll(replace[i], "");
                message = answer;
            } else {
                answer = message;
            }
        }



    }
}
