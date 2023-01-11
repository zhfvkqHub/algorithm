package main.java.programmers.lv2;

// LV2 멀리 뛰기
public class Solution61 {

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        solution61.solution(4);
    }

    public long solution(int n) {
        int dp[] = new int[n+1];
        if(n == 1)
            return 1;

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}


