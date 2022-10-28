package main.java.baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution3 {

   static class Node{
       int x, y, cnt;

       public Node(int x, int y, int cnt) {
           this.x = x;
           this.y = y;
           this.cnt = cnt;
       }
   }

   private static int N, M, answer =0;
   private static int[][] graph;

   private static int nx[] = {-1, 0, 1, 0};
   private static int ny[] = {0, 1, 0, -1};
   private static Queue<Node> q = new LinkedList<>();
   private static boolean visited[][];

   public static void BFS(int a, int b, int cnt){
       q.add(new Node(a,b,cnt));

       while(!q.isEmpty()){
           Node tmp = q.poll();

           if(tmp.x == N-1 && tmp.y == M-1){
               answer = tmp.cnt;
               return;
           }

           for(int i = 0; i<4; i++){
               int tx = tmp.x + nx[i];
               int ty = tmp.y + ny[i];
               if(tx<0 || ty<0 || tx>=N || ty>=M || visited[tx][ty] || graph[tx][ty] == 0) continue;

               q.add(new Node(tx, ty, tmp.cnt + 1));
               visited[tx][ty] = true;
           }
       }

   }
   public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            char[] b = sc.next().toCharArray();
            for(int j=0; j<M; j++){
                graph[i][j] = b[j] - '0';
            }
        }

        visited[0][0] = true;
        BFS(0,0,1);
        System.out.println(answer);

   }

}
