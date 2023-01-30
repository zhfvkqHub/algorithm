package main.java.programmers.lv2;

import java.util.Stack;

// LV2 택배 배달과 수거하기
public class Solution72 {

    public static void main(String[] args) {
        Solution72 Solution72 = new Solution72();
        Solution72.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
    }

    private void street(int cap, Stack<Integer> very) {
        int boxCnt = 0;

        while (!very.isEmpty() && boxCnt <= cap) {

            if (very.peek() + boxCnt <= cap) {
                boxCnt += very.pop();
            } else {
                very.push(very.pop() - (cap-boxCnt));
                break;
            }

        }
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> very = new Stack<>();
        Stack<Integer> su = new Stack<>();

        for (int i = 0; i < deliveries.length; i++) {
            very.push(deliveries[i]);
            su.push(pickups[i]);
        }

        while (!very.isEmpty() && very.peek() == 0) very.pop();

        while (!su.isEmpty() && su.peek() == 0)su.pop();

        while (!(very.isEmpty() && su.isEmpty())) {
            answer += Math.max(very.size() * 2, su.size() * 2);
            street(cap, very);
            street(cap, su);
        }

        return answer;
    }

}


