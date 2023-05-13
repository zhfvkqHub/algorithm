package main.java.programmers.lv3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
 */
public class Solution18 {

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public int solution(int n, int[][] edge) {

        int[] dist = new int[n+1];
        boolean[][] map = new boolean[n+1][n+1];

        for(int i =0; i<edge.length; i++){
            map[edge[i][1]][edge[i][0]] = map[edge[i][0]][edge[i][1]] = true;
        }

        LinkedList<Integer> que = new LinkedList<>();
        que.add(1);

        while(!que.isEmpty()){
            int temp = que.pollFirst();
            for(int i = 2; i < n+1; i++){
                if(map[temp][i] && dist[i] == 0){
                    que.addLast(i);
                    dist[i] = dist[temp]+1;
                }
            }
        }

        Arrays.sort(dist);

        int i = dist.length-1;
        for(; i > 0; --i){
            if(dist[i] != dist[i-1]) break;
        }

        return dist.length - i;
    }
}



