package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

// LV2 두 큐 합 같게 만들기
public class Solution43 {

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        solution43.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
    }

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0L;
        long sum2 = 0L;

        for(int n1 : queue1) {
            q1.offer(n1);
            sum1 += n1;
        }
        for(int n2 : queue2) {
            q2.offer(n2);
            sum2 += n2;
        }

        while(sum1 != sum2) {
            if(sum1 > sum2) {
                int n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.offer(n);
            } else {
                int n = q2.poll();
                sum2 -= n;
                sum1 += n;
                q1.offer(n);
            }
            answer++;
            if(answer > 600000) return -1;
        }

        return answer;
    }

}


