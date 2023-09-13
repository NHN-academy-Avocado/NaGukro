package org.example.chapter3.exercise;

public class TextBook extends Book{
    private String course;

    public TextBook(String title, String autor, String course) {
        super(title, autor);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
