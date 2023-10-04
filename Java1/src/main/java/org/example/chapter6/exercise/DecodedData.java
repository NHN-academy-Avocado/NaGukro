package org.example.chapter6.exercise;

public class DecodedData {
    private String string;
    private int d;

    public DecodedData(String string,int d) {
        this.string = string;
        this.string = setDecodedString(d);
    }

    public String getString() {
        return string;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "DecodedData{" +
                "string='" + string + '\'' +
                '}';
    }

    public String setDecodedString(int d) {
        char c;
        int ci;
        String decodeText ="";
        for (int i = 0; i < string.length(); i++) {
          c = string.charAt(i);
          ci  = (int) c +10;
          decodeText = decodeText + (char) ci;
        }
        return decodeText;
    }


    public void print() {
        System.out.println(this);
    }
}
