package main.java.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution4 {
   private static int N, M, answer =0;
   private static int[] graph;
   private static ArrayList<Integer>[] node;
   private static boolean visited[];

   public static void BFS(int su){
       Queue<Integer> q = new LinkedList<>();
       q.offer(su);
       visited[su] = true;

       while (!q.isEmpty()){
           int a = q.poll();
           for(Integer i : node[a]){
               if(visited[i]) continue;
               visited[i] = true;
               answer ++;
               q.add(i);
           }
       }
   }
   public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        node = new ArrayList[N+1];

        for(int j=1; j<=N; j++){
            node[j] = new ArrayList<>();
       }

        for(int i=1; i<=M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a].add(b);
            node[b].add(a);
        }

        BFS(1);
        System.out.println(answer);

   }

}
