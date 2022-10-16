package main.java.programmers.lv1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution11 {

    private static LinkedList<Integer> nodes[];
    private static boolean visit[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        // node 초기화
        nodes = new LinkedList[n + 1];
        for(int i = 1; i < n; i ++){
            nodes[i] = new LinkedList<>();
        }

        for(int i = 1; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[a].add(b);
            nodes[b].add(a);
        }

        for(int i = 1; i < n; i++){
            nodes[i].sort(null);
        }

        visit = new boolean[n+1];
        DFS(v);
        System.out.println();
        visit = new boolean[n+1];
        BFS(v);

    }

    private static void BFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        visit[v] = true;

        que.add(v);
        while (!que.isEmpty()){
            int tmp = que.poll();
            System.out.print(tmp + " ");
            for(int i = 0; i < nodes[tmp].size(); i++){
                if(visit[nodes[tmp].get(i)]) continue;

                que.add(nodes[tmp].get(i));
                visit[nodes[tmp].get(i)] = true;

            }
        }

    }
    private static void DFS(int v) {
        System.out.print(v + " ");
        visit[v] = true;

        for(int i = 0; i < nodes[v].size(); i++){
            if(visit[nodes[v].get(i)]) continue;

            DFS(nodes[v].get(i));
        }

    }


}


