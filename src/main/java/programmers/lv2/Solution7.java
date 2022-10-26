package main.java.programmers.lv2;
// 피보나치 수
public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        solution7.solution(7);
        solution7.solution2(7);

    }

    // 재귀함수 타임아웃..
    public long solution(int n) {
        long answer = 0;

        if(n < 2) return answer = n;
        answer = solution(n-1) + solution(n-2);

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;
        long[] list = new long[n+1];
        list[0]=0L;
        list[1]=1L;

        for(int i=2; i<=n; i++){
            list[i]= (list[i-1] + list[i-2])%1234567L;
        }

        answer = (int)(list[n]);

        return answer;
    }
}
