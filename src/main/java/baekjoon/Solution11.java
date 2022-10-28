package main.java.baekjoon;


import java.util.*;

public class Solution11 {

    public static void main(String[] args) {

        Solution11 solution11 = new Solution11();
        int[][] roads = new int[][]{{5,4,6},{5,2,5},{0,4,2},{2,2,3},{1,2,7},{0,1,3}};
        solution11.solution2(6,17, roads);

    }

    class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob){
            return this.cost - ob.cost;
        }
    }

    public int[] solution2(int n, int k, int[][] roads){
        int[] answer={};
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(i).add(new Edge(roads[i][1],roads[i][2]));
        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(0,0));

        int[] dis = new int[n];
        dis[0] = 0;

        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowConst = tmp.cost;

            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowConst + ob.cost){
                    dis[ob.vex] = nowConst + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowConst + ob.cost));
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(dis[i]);
        }

        return answer;
    }


    void DFS(int n, int sum, int[][] Dist){

        for (int h = 0; h < 100; h++) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (Dist[i][h] + Dist[h][j] == 17) {
                        Dist[i][j] = Dist[i][h] + Dist[h][j];
                    }
                }
            }
        }

    }

    public int[] solution(int n, int k, int[][] roads){
        int[] answer={};
        int[][] Dist = new int[n][n];

        for (int i = 0; i < roads.length; i++) {
            Dist[roads[i][0]][Dist[i][1]] = Dist[i][2];
            Dist[roads[i][1]][Dist[i][0]] = Dist[i][2];
        }

        DFS(n, 0, Dist);

        for (int i = 0; i < Dist[0].length; i++) {
            if (Dist[0][i] == k)
                System.out.println(i);
        }

        return answer;

    }




}
