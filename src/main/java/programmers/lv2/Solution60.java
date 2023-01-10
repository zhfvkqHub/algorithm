package main.java.programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

// LV2 최솟값 만들기
public class Solution60 {

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        solution60.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
    }

    // TIMEOUT ㅠㅠ
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        while (!a.isEmpty()) answer += a.poll() * b.poll();

        return answer;
    }
}


