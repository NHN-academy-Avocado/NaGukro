package org.example.chapter3.exercise;

import javax.swing.JOptionPane;

public class Book {

    //Todo 3-1
    private String title;
    private String autor;
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public int getPrice() {
        return price;
    }

    public Book(String title, String autor) {
        this.title = title;
        this.autor = autor;
    }
    public void printBook() {
        System.out.println(title);
        System.out.println(autor);
    }

    public void printPrice() {
        System.out.println(price);
    }

    public void printBookPrice() {
        System.out.println(this);
    }
    public void windowBook() {
        JOptionPane.showMessageDialog(null, this);
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", price=" + price +
                '}';
    }
}
