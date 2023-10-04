package org.example.chapter3.exercise;

import javax.swing.JOptionPane;

public class Test {
    public static void main(String[] args) {
        //Todo 8.1~8
        BolzanoTextBook bolzanoTextBook = addTextBook();
//
        System.out.println(bolzanoTextBook);

        Novel novel = addNovel();

        System.out.println(novel);

        int price = Integer.parseInt(JOptionPane.showInputDialog("How much is it?"));

        bolzanoTextBook.setPrice(price);

        System.out.println(bolzanoTextBook);




    }

    //Todo 8-1
    private static BolzanoTextBook addTextBook() {
        String title = JOptionPane.showInputDialog("What is title?");
        String autor = JOptionPane.showInputDialog("What is autor?");
        String course = JOptionPane.showInputDialog("What is course?");
        String faculty = JOptionPane.showInputDialog("who is faculty?");
        BolzanoTextBook bolzanoTextBook = new BolzanoTextBook(title, autor, course, faculty);
        return bolzanoTextBook;
    }

    private static void printTextBook(BolzanoTextBook bolzanoTextBook) {
        System.out.println(bolzanoTextBook);
    }


    private static Novel addNovel() {
        Book book=  addSecoundBook();
        String type = JOptionPane.showInputDialog("What is type?");

        Novel novel = new Novel(type, book);
        return novel;
    }

    private static Book addSecoundBook() {
        String title = JOptionPane.showInputDialog("What is title?");
        String autor = JOptionPane.showInputDialog("What is autor?");
        Book book = new Book(title, autor);
        return book;
    }


}
