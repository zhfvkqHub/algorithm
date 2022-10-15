package main.java;

import java.util.*;

// 노드를 이용한 BFS, DFS
public class Main {
    private static ArrayList<Integer>[] nodes;
    private static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int v = sc.nextInt();
        int n = 4;
        int m = 5;
        int v = 1;

        // node 초기화
        nodes = new ArrayList[n + 1];
        // 배열 원소를 인스턴스로 지정
        for(int i = 1; i < n + 1; i ++){
            nodes[i] = new ArrayList<>();
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("1 2");
        list.add("1 3");
        list.add("1 4");
        list.add("2 4");
        list.add("3 4");

        for(int i = 0; i < m; i++){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
            String[] arr = list.get(i).split(" ");
            nodes[Integer.parseInt(arr[0])].add(Integer.valueOf(arr[1]));
            nodes[Integer.parseInt(arr[1])].add(Integer.valueOf(arr[0]));
        }

        for(int i = 1; i <= n; i++){
            nodes[i].sort(null); // 오른차순 정렬
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