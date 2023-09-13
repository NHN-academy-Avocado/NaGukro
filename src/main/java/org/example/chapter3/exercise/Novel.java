package org.example.chapter3.exercise;

public class Novel {
    private String type;

    private Book book;

    public Novel(String type, Book book) {
        this.type = type;
        this.book = book;
    }

    @Override
    public String toString() {
        return  book + "장르는 :" + type;
    }


}
