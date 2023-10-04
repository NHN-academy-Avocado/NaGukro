package org.example.chapter10.exercise;

public class Exercise7 {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;

        double probLand = 0.4; // 육지이 될 확률
        Moor moor = new Moor(rows, columns, probLand);

        // Moor 출력
        System.out.println("Moor:");
        System.out.println(moor);

        // Traversal 인스턴스 생성 및 결과 출력
        Traversal traversal = new Traversal(moor);
        if (traversal.existsTraversal()) {
            System.out.println(traversal);
        } else {
            System.out.println("이동 경로가 존재하지 않습니다");
        }
        System.out.println("탐색 횟수: " + traversal.getSearchCount());


    }
}
