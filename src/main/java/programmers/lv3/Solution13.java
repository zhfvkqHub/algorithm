package main.java.programmers.lv3;

/**
 * 최고의 집합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938?language=java
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution13 Solution13 = new Solution13();
        Solution13.solution(2, 9);
    }

    public int[] solution(int n, int s) {
        if(n > s)
            return new int[]{-1};

        int[] answer = new int[n];
        int mok = s / n;
        int rest = s % n;
        for(int i = n - 1; i >= 0; i--){
            answer[i] = mok;
            if(rest > 0) {
                answer[i]++;
                rest--;
            }
        }
        return answer;
    }

}



