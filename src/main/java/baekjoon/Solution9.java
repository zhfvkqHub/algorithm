package main.java.baekjoon;

// 프로그래머스2 땅따먹기
public class Solution9 {

    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length;i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
        return Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]), Math.max(land[land.length-1][2],land[land.length-1][3]));
    }



}
