package main.java.programmers.lv2;

// LV2 예상 대진표
public class Solution10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        solution10.solution(8,4,7);

    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while(a != b) {
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }

        System.out.println(answer);
        return answer;
    }

}
