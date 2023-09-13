package org.example.chapter2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String name = "NaGukRo";
        String first = name.substring(0,1);
        String last = name.substring(name.length()-1, name.length());
        System.out.println(first);
        System.out.println(last);

        String name1 = "NaGukRo";
        System.out.println(name1.substring(0,1));
        System.out.println(name1.substring(name1.length()-1,name1.length()));

        String a = JOptionPane.showInputDialog("Insert Input");
        String b = a.substring(0,1);
        String c = a.substring(a.length()-1,a.length());
        System.out.println(c + a.substring(1, a.length()-1) + b);




        String s = JOptionPane.showInputDialog("Insert Input");
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.replace(0, 1, s.substring(s.length()-1, s.length()));
        stringBuffer.replace(stringBuffer.length()-1, stringBuffer.length(), s.substring(0,1));


        System.out.println(stringBuffer);

    }
}