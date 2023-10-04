package org.example.chapter4.exercise;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        //Todo 4-3
        int a = Integer.parseInt(JOptionPane.showInputDialog("첫번째 정수를 입력하세요"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("두번째 정수를 입력하세요"));
        System.out.println(a/b);
        System.out.println(Math.sqrt(a*b));
        System.out.println(bigger(a,b));
        //4-4
        System.out.println(even(4));

        //Todo 4-5
        short x = 22;
        byte y = (byte) x;
        System.out.println(y);

        //Todo 4-6
/*        byte b;
        short s;
        int i;
        long l;
        float f;
        double d;
        char c;
        boolean b1, b2;*/

/*        1. b+10L <Long>
        2. (b+i)*l <Long>
        3. (b+i)*l+f <Float>
        4. s/f + Math.sin(f) <double> -> Math.sin의 return 값이 double
        5. c == 'b' <boolean>
        6. l+1.5f <Float>
        7. i<10 <boolean>
        8. b1 == (f >= 5.0) <boolean>
        9. b1 && !b2  <boolean>*/


        //Todo 4-7
/*        s = 65L; -> Error
        f = i+100;
        i = 2*b + l; -> Error
        b1 = s; => Error
        b2 = s >= 57;
        c = b; -> Error
        c = 'b';*/



    }

    public static boolean bigger(int a, int b ) {
        return a > b;
    }

    public static double convertLireEuro(int lira) {
        //Todo 4-1
        Double Euro = 1.6 * lira;
        return Euro;
    }


    public static boolean sumOverflow(byte x, byte y) {
        //Todo 4-2
        short num1 = x;
        short num2 = y;

        short result = (short) (num2 + num1);
        return result <= -128 || result >= 127; // 오버플로우가 발생하면 false
    }

    public static boolean even(long x) {
        //Todo 4-4
        return x%2 ==0;
    }




}