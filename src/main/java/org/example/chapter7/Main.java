package org.example.chapter7;

public class Main {
    public static void main (String[] args) {
        ApartmentOwner p = new ApartmentOwner("Mario Rossi");
        p.setApartment("Via della Camilluccia, 29", 0);
        p.setApartment("Largo di Torre Argentina, 42", 1);
        p.setApartment("P.zza Conca D’Oro, 9", 2);
        p.setApartment("Via del Corso, 30", 5);
        p.setApartment("Via Trionfale, 2500", 8);
        System.out.println(p);

        System.out.println();
        System.out.println(p.getOwner() + " has " +
                p.countApartments() + " apartments");
        System.out.println("Apartment 2: " + p.getApartment(2));

        System.out.println();
        p.reorganizeApartments();
        System.out.println(p);
    }


    public static int[] matrixSumRows(int[][] M) {
        int[] C = new int[M.length]; // array를 생성합니다.
        for (int i = 0; i < M.length; i++) { // M의 행을 반복합니다.
            C[i] = 0; // 요소를 초기화합니다.
            for (int j = 0; j < M[i].length; j++) // i행의 요소를 반복합니다.
                C[i] += M[i][j]; // i행의 요소를 누적합니다.
        }
        return C;
    }
}
