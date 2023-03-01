package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

// 미로탈출
public class Solution80 {

    public static void main(String[] args) {
        Solution80 Solution80 = new Solution80();
        Solution80.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
    }

    class Node {
        int x;
        int y;
        int t;

        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    char[][] m;
    int[] s, l, e;
    int min;
    int[] dx = new int[] {-1, 0, 1, 0}, dy = new int[] {0, 1, 0, -1};
    int mx, my;
    int INF = 20000;
    public int solution(String[] maps) {
        min = INF;
        mx = maps.length; my = maps[0].length();
        m = new char[mx][my];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < my; j++) {
                char c = maps[i].charAt(j);
                m[i][j] = c;
                switch (c) {
                    case 'S' : s = new int[] {i, j}; break;
                    case 'L' : l = new int[] {i, j}; break;
                    case 'E' : e = new int[] {i, j}; break;
                }
            }
        }
        int a = bfs(s, l), b = bfs(l, e);
        return a != -1 && b != -1 ? a + b : -1;
    }

    public int bfs(int[] a, int[] b) {
        boolean[][] visited = new boolean[mx][my];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a[0], a[1], 0));

        while (!q.isEmpty()) {
            Node now = q.remove();
            int x = now.x, y = now.y;
            int time = now.t;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (x == b[0] && y == b[1])
                return time;


            for (int i = 0; i < 4; i++) {
                int r = x + dx[i], c = y + dy[i];

                if (isCorrectRange(r, c) && m[r][c] != 'X')
                    q.add(new Node(r, c, time + 1));

            }
        }
        return -1;
    }
    public boolean isCorrectRange(int i, int j) {
        return 0 <= i && i < mx && 0 <= j && j < my;
    }
}



