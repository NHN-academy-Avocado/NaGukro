package org.example.chapter9;

public class Exercise2 {

    private int x = 101;

    private void f(int x) {
        x++;
        g();
    }

    private void g() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Exercise2 e = new Exercise2();
        int x = 200;
        e.f(x);
    }

    //101을 인쇄, 객체 e의 x를 인쇄
}
