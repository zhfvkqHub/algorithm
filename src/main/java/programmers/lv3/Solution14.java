package main.java.programmers.lv3;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class Solution14 {

    public static void main(String[] args) {
        Solution14 Solution14 = new Solution14();
        Solution14.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;

        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i])
                dfs(computers, chk, i);
        }
    }

}



