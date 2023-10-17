package org.chapter.chapter3;

public class Exercise1 {
    public static void main(String[] args) {
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);

        int count = 1;

        while (dice1 + dice2 != 2) {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            count++;
        }

        System.out.println(count);
    }

}
