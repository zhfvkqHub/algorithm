package main.java.programmers.lv2;

import java.util.ArrayList;

// LV2 줄 서는 방법
public class Solution22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.solution(3,5);
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long temp = k - 1;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {

            if (temp == 0) {
                answer[i] = list.get(0);
                list.remove(0);
                continue;
            }

            long num = temp / factorial(n - i - 1);
            answer[i] = list.get((int)num);
            list.remove((int)num);
            temp = temp % factorial(n - i - 1);
        }

        return answer;
    }

    public long factorial(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
