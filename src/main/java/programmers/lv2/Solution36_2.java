package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LV2 타겟 넘버 bfs
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Solution36_2 {

    public static void main(String[] args) {
        Solution36_2 solution36 = new Solution36_2();
        solution36.solution(new int[]{1, 1, 1, 1, 1}, 3);
    }


    public int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }

    private static class Pair {
        int position;
        int sum;
        public Pair(int position, int sum) {
            this.position = position;
            this.sum = sum;
        }
    }

    private static int bfs(int[] numbers, int target) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, numbers[0]));
        q.add(new Pair(0, numbers[0] * -1));

        int answer = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.position == numbers.length - 1) {
                if (p.sum == target)
                    answer++;
                continue;
            }

            int nPosition = p.position + 1;
            if (nPosition >= numbers.length)
                continue;

            q.add(new Pair(nPosition, p.sum + numbers[nPosition]));
            q.add(new Pair(nPosition, p.sum + numbers[nPosition] * -1));
        }

        System.out.println(answer);

        return answer;
    }
}


