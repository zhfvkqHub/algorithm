package main.java.programmers.lv3;

import java.util.*;

/**
 * 미로 탈출 명령어
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365?language=java
 */
public class Solution7 {

    public static void main(String[] args) {
        Solution7 Solution7 = new Solution7();
        Solution7.solution(3,4,2,	3,3,1,5);
    }

    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, -1, 1, 0};

    public class Point {
        public int x, y;
        public String sb;

        public Point(int x, int y, String sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    public char convertDir(int d) {
        char[] dirs = {'d', 'l', 'r', 'u'};
        if (d >= 0 && d < dirs.length) {
            return dirs[d];
        }
        return '0';
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] chk = new boolean[n][m][k+1];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x-1, y-1, ""));
        chk[x-1][y-1][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == r-1 && cur.y == c-1) {
                if (cur.sb.length() == k)
                    return cur.sb;
            }
            if (cur.sb.length() == k)
                continue;

            for (int d = 0; d < 4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];
                if (X < 0 || Y < 0 || X >= n || Y >= m || chk[X][Y][cur.sb.length() + 1])
                    continue;
                chk[X][Y][cur.sb.length() + 1] = true;
                q.add(new Point(X, Y, cur.sb + convertDir(d)));
            }
        }
        return "impossible";
    }

}



