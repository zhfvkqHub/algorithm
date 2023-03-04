package main.java.programmers.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

// 야근 지수
public class Solution2 {

    public static void main(String[] args) {
        Solution2 Solution2 = new Solution2();
        Solution2.solution(4, new int[]{4, 3, 3});
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        int check = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            check += work;
            queue.add(work);
        }

        if (check <= n)
            return answer;

        for (int i = 0; i < n; i++) {
            int cur = queue.poll();
            queue.add(cur - 1);
        }

        while (!queue.isEmpty())
            answer += Math.pow(queue.poll(), 2);

        return answer;
    }
}



