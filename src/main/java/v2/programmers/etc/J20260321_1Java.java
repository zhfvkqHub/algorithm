package main.java.v2.programmers.etc;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * [Jabda]
 * 그리디 + 우선순위큐
 */
class J20260321_1Java {

    public int solution(int H, int W, int[] D) {
        int n = W - 1; // 학생 수, 포트 수

        Interval[] intervals = new Interval[n];
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            long d = D[i - 1];

            // 최소 세로 거리 H보다 랜선 길이가 짧으면 연결 불가
            if (d < H) {
                continue;
            }

            long remain = d * d - 1L * H * H;
            long r = (long) Math.sqrt(remain);

            // 부동소수 오차 보정
            while ((r + 1) * (r + 1) <= remain) {
                r++;
            }
            while (r * r > remain) {
                r--;
            }

            int left = (int) Math.max(1, i - r);
            int right = (int) Math.min(n, i + r);

            if (left <= right) {
                intervals[idx++] = new Interval(left, right);
            }
        }

        Arrays.sort(intervals, 0, idx, (a, b) -> {
            if (a.left != b.left) {
                return Integer.compare(a.left, b.left);
            }
            return Integer.compare(a.right, b.right);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int p = 0;

        // 포트를 1번부터 n번까지 순서대로 사용
        for (int port = 1; port <= n; port++) {
            // 현재 포트까지 시작 가능한 학생들 후보 등록
            while (p < idx && intervals[p].left <= port) {
                pq.offer(intervals[p].right);
                p++;
            }

            // 이미 이 포트보다 오른쪽 끝이 작은 학생은 불가능
            while (!pq.isEmpty() && pq.peek() < port) {
                pq.poll();
            }

            // 가장 빨리 끝나는 학생에게 현재 포트 배정
            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }
        }

        return answer;
    }

    static class Interval {
        int left;
        int right;

        Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        //각 학생이 자신의 랜선 길이로 도달 가능한 인터넷 포트 구간 [L, R]을 만들고,
        //각 포트는 한 명만 사용할 수 있을 때 최대 몇 명을 연결할 수 있는지 구한다.

        int H = 10;
        int W = 10;
        int[] D = {1, 5, 15, 13, 2, 4, 10, 9, 11};

        J20260321_1Java solution = new J20260321_1Java();
        System.out.println("answer :: " + solution.solution(H, W, D)); // 4
    }
}
