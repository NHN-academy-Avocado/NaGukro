package org.example.chapter10.exercise;

public class Exercise4 {
    public static void main(String[] args) {
//        System.out.println(gcd(4,2));
        System.out.println(prime(10,5));
        System.out.println(rest(10,3));
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static boolean prime(int num1, int num2) {
        if (num1==1 || num2 ==1) {
            return true;
        } else if ( num1==num2) {
            return false;
        } else if (num1<num2) {
            return prime(num1,num2-num1);
        } else{
            return prime(num1-num2, num2);
        }
    }

    public static int rest(int num1, int num2) {
        if(num1 < 0) {
            return rest(num1+num2,num2);
        } else if (num1>num2) {
            return rest(num1-num2,num2);
        } else
            return num1;
    }
}
