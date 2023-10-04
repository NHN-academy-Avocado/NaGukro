package org.example.chapter3.exercise;

public class BolzanoTextBook extends TextBook {
    private String faculty;

    public BolzanoTextBook(String title, String autor, String course, String faculty) {
        super(title, autor, course);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + super.getTitle() + '\'' +
                ", autor='" + super.getAutor() + '\'' +
                ", course='" + super.getCourse() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", faculty=" + this.getFaculty() +
                '}';
    }
}
