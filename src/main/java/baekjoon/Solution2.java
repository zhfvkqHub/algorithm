package main.java.baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {

    class Info {
        int x, y, dist;
        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

   static int n, m;
   static int[][] nodes;
   static int[][] dis;
   static int[] dx = {-1, 0, 1, 0};
   static int[] dy = {0, 1, 0, -1};

   public static void main(String args[]) throws IOException {
       Scanner sc = new Scanner(System.in);

       String[] nm = sc.nextLine().split(" ");
       n = Integer.parseInt(nm[0]);
       m = Integer.parseInt(nm[1]);

       nodes = new int[n+1][m+1];
       dis = new int[n+1][m+1];

       for(int i = 1; i <= n; i++){
           String[] line = sc.nextLine().split("");
           for(int j = 1; j <= m; j++){
               nodes[i][j] = Integer.parseInt(line[j-1]);
           }
       }

       Solution2 so = new Solution2();
       System.out.println(so.BFS());
   }

    private int BFS() {
       Queue<Info> qu = new LinkedList<>();
       dis[1][1] = 1;
       qu.offer(new Info(1, 1,1));

       while(!qu.isEmpty()){
               Info graph = qu.poll();
               //종료조건
               if(graph.x == n && graph.y == m) return graph.dist;
               //상하좌우 이동
               for(int i = 0; i < 4; i++){
                   int nX = graph.x+dx[i];
                   int nY = graph.y+dy[i];

                   if(nX > 0 && nX <= n && nY > 0 && nY <= m && dis[nX][nY] == 0 && nodes[nX][nY] == 1){
                       qu.offer(new Info(nX, nY, graph.dist + 1));
                       dis[nX][nY] = 1;
                   }
               }
       }
        return -1;
    }

}
