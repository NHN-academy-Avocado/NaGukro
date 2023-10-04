package org.example.chapter10.exercise;

public class Traversal {

    private int[] traversal;
    private Moor moor;
    private boolean found;
    private boolean[][] visited;
    private int searchCount; // 탐색 횟수를 저장할 필드



    public Traversal(Moor m) {
        moor = m;
        traversal = new int[moor.getNumColumns()];
        visited = new boolean[m.getNumRows()][m.getNumColumns()];
        searchCount = 0; // 탐색 횟수 초기화
        found = traverseMoor(moor, traversal);

    }

    public int getSearchCount() {
        return searchCount;
    }


    public Moor moor() {
        return moor;
    }

    public boolean existsTraversal() {
        return found;
    }

    public int length() {
        if (found)
            return traversal.length;
        else
            throw new RuntimeException("Traversal: traversal does not exist");
    }

    public int step(int i) {
        if (found)
            return traversal[i];
        else
            throw new RuntimeException("Traversal: traversal does not exist");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!found) {
            sb.append("Traversal does not exist.\n");
            return sb.toString();
        }

        for (int i = 0; i < moor.getNumRows(); i++) {
            for (int  j = 0; j < moor.getNumColumns(); j++) {
                if (!moor.land(i, j)) {
                    // 믈
                    sb.append("o");
                } else if (j < traversal.length && traversal[j] == i) {
                    // 육지 경로
                    sb.append("#");
                } else {
                    // 경로가 아닌 땅
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }


    // auxiliary methods

    private  boolean traverseMoor(Moor m, int[] path) {
        for (int row = 0; row < m.getNumRows(); row++)
            if (searchTraversal(m, row, 0, path)) return true;
        return false;
    }

    private boolean searchTraversal(Moor m, int r, int c, int[] path) {
        searchCount++; // 탐색 횟수 증가
        if (!m.land(r, c) || visited[r][c])
            return false;


        visited[r][c] = true; //방문지역 표시
        path[c] = r;

        if (c == m.getNumColumns()-1)
            return true;
        else
            return

                    searchTraversal(m, r-1, c+1, path) ||
                    searchTraversal(m, r,   c+1, path) ||
                    searchTraversal(m, r+1, c+1, path);
    }



}