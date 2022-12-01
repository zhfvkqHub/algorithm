package main.java.programmers.lv2;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// LV2 게임 맵 최단거리
public class Solution35 {

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        solution35.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
    }

    public static int solution(int[][] maps) {
        int X = maps[0].length;
        int Y = maps.length;
        boolean[][] visited = new boolean[Y][X];
        Queue<Point> q = new LinkedList<>();

        int x = 0;
        int y = 0;
        int size = 0;
        int cnt = 0;
        new Point();
        Point p;
        q.add(new Point(Y-1,X-1));

        while(q.isEmpty()==false) {
            size = q.size();
            cnt++;

            for(int i=0;i<size;i++){
                p = q.peek();
                x = p.y;
                y = p.x;
                q.remove();

                if(visited[y][x]==true) continue;

                maps[y][x] = 0;
                visited[y][x] = true;

                if(x==0 && y==0) {
                    return cnt;
                }

                if(x-1>-1 && maps[y][x-1]==1) { //왼쪽
                    q.add(new Point(y,x-1));
                }

                if(x+1<X && maps[y][x+1]==1) { //오른쪽
                    q.add(new Point(y,x+1));
                }

                if(y-1>-1 && maps[y-1][x]==1) { //위쪽
                    q.add(new Point(y-1,x));
                }

                if(y+1<Y && maps[y+1][x]==1) { //아래쪽
                    q.add(new Point(y+1,x));
                }
            }
        }

        return -1;
    }
}


