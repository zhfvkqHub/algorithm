package main.java.programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

// LV2 디펜스 게임
public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        solution41.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
    }

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int en : enemy) {
            PQ.add(en);

            while (k > 0 && n < en && !PQ.isEmpty()) {
                n += PQ.poll();
                k--;
            }
            n -= en;

            if (n < 0) break;
            answer++;
        }
        return answer;
    }



}


