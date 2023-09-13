package org.example.chapter3.exercise;

public class MessageText {
    //Todo 3-3
    private String code;
    private String message;

    public MessageText(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void printMessage() {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "MessageText{" +
                "message='" + message + '\'' +
                '}';
    }
}
