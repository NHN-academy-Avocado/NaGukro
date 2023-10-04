package org.example.chapter5.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    private int top;
    private int middle;
    private int bottom;

    private int[] len;

    public int getTop() {
        return top;
    }

    public int getMiddle() {
        return middle;
    }

    public int getBottom() {
        return bottom;
    }

    //Todo 5-4 삼각형이 될수 있는지
    public void isOk() {
        if (top >= middle + bottom) {
            System.out.println("삼각형이 될 수 없습니다.");
        } else {
            System.out.println("삼각형이 될 수 있습니다.");
        }
    }

    //Todo 5-4 둘레 구하기
    public void perimeter() {
        System.out.println(top + middle + bottom);
    }

    public Triangle(int[] len) {
        Arrays.sort(len);
        this.top= len[0];
        this.middle = len[1];
        this.bottom = len[2];
        isOk();
    }

    public void retuenLength() {
        System.out.println("가장 긴 변의 길이 :"+this.top + ", 중간 변의 길이 :"+this.middle +", 가장 짧은 변의 길이 :"+this.bottom);
    }


    public void area() {
        int s = (top+middle+bottom)/2;
        double result = Math.sqrt(s*(s-top)*(s-middle)*(s-bottom));
        System.out.println(result);
    }

    public void type() {
        if (top == middle && middle == bottom) {
            System.out.println("정삼각형입니다");
        }else if (top == middle || middle == bottom) {
            System.out.println("이등변삼각형입니다");
        } else {
            System.out.println("그냥 삼각형입니다");
        }
    }
}
