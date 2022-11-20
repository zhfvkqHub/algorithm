package main.java.programmers.lv2;

import java.util.PriorityQueue;

// LV2 더 맵게
public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        solution26.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            qu.add(scoville[i]);

        int count = 0;
        while(qu.size() > 1 && qu.peek() < K){

            int weakHot = qu.poll();
            int secondWeakHot = qu.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            qu.add(mixHot);
            count++;

        }

        if(qu.size() <= 1 && qu.peek() < K)
            count = -1;

        return count;
    }
}
