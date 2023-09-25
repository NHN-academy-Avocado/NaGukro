package org.example.chapter9;

public class Exercise1 {
    /*    public static void main(String[] args) {
            for (int i = 0, j = 0; i < 10, j < 10; i++, j++) { //&&연산자
                System.out.println(i + " + " + j + " = " + (i+j));
            }
            System.out.println("I've printed out the sums of i and j up to "
                    + i + "," + j); //for문이 끝나고 i,j
        }*/
    public static void main(String[] args) {
        int i = 0, j = 0;
        for (; i < 10 && j < 10; i++, j++) {
            System.out.println(i + " + " + j + " = " + (i + j));
        }
        System.out.println("I've printed out the sums of i and j up to " + i + "," + j);
    }


}
