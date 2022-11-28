package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

// LV2 카카오프렌즈 컬러링북
public class Solution32 {

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        solution32.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1},{0, 0, 0, 3}, {0, 0, 0, 3}});
    }

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {

        boolean[][] check = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int tempMax = 0;
                if (!check[i][j] && picture[i][j] != 0) {
                    check[i][j] = true;
                    q.add(new Node(i, j));
                    tempMax++;

                    while (!q.isEmpty()) {

                        Node current = q.poll();

                        int nextX = 0;
                        int nextY = 0;

                        for (int k = 0; k < 4; k++) {
                            nextX = current.x + dx[k];
                            nextY = current.y + dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || check[nextX][nextY])
                                continue;
                            if (picture[current.x][current.y] == picture[nextX][nextY]) {
                                check[nextX][nextY] = true;
                                q.add(new Node(nextX, nextY));
                                tempMax++;
                            }
                        }
                    }
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea < tempMax ? tempMax : maxSizeOfOneArea;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(numberOfArea + "," + maxSizeOfOneArea);

        return answer;
    }

}


