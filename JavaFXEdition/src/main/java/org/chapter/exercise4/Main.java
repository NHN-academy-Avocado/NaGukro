package org.chapter.exercise4;

import java.util.Arrays;
import java.util.List;
import javax.print.DocFlavor;

public class Main {
    //Reflection API
    private static final List<Integer> arr = Arrays.asList(1,2,3);


    public static void main(String[] args) {
        arr.add(0);
    }
}
