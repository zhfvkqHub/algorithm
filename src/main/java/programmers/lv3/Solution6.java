package main.java.programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 디스크 컨트롤러
public class Solution6 {

    public static void main(String[] args) {
        Solution6 Solution6 = new Solution6();
        Solution6.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
    }

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, Comparator.comparingInt(x -> x[0])); // 시작 시간 빠른 순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1])); // 실행 시간 적은 순

        int time =0, idx=0, answer=0;
        while(idx < jobs.length || !pq.isEmpty()) {

            while(idx < jobs.length && jobs[idx][0] <= time)
                pq.add(jobs[idx++]);

            if(pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            int[] job = pq.poll();
            time += job[1];
            answer += time-job[0];
        }
        return answer / jobs.length;

    }
}



