package main.java.programmers.lv2;

// LV2 2 x n 타일링
public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        solution34.solution(4);
    }

    public int solution(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }

        return dp[n];
    }
}


