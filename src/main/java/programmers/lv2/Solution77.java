package main.java.programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 숫자 변환하기
public class Solution77 {

    public static void main(String[] args) {
        Solution77 Solution77 = new Solution77();
        Solution77.solution(10,40,50);
    }

    private int[] dp;
    private Queue<Integer> queue = new LinkedList<>();

    private void move(int next, int y, int dist) {

        if (next > y)
            return;

        if (dp[next] == -1 || dp[next] > dist) {
            dp[next] = dist;
            queue.add(next);
        }
    }

    public int solution(int x, int y, int n) {

        dp = new int[y + 1];
        Arrays.fill(dp, -1);

        queue.add(x);
        dp[x] = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();
            move(now + n, y, dp[now] + 1);
            move(now * 2, y, dp[now] + 1);
            move(now * 3, y, dp[now] + 1);
        }
        return dp[y];
    }

}


