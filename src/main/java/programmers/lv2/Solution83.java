package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 연속된 부분 수열의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870?language=java
 */
public class Solution83 {

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        solution83.solution(new int[]{1, 2, 3, 4, 5}, 7);
    }

    public int[] solution(int[] seq, int k) {
        List<int[]> list = new ArrayList<>();

        int sum = 0;
        int l = 0;
        int r = 0;
        int n = seq.length;

        while(l <= r && r < n) {
            sum += seq[r];
            if (sum >= k) {
                while(sum > k) {
                    sum -= seq[l];
                    l++;
                }
                if (sum == k)
                    list.add(new int[] { l, r });
            }

            r++;
        }

        list.sort((a, b) -> {
            int adis = a[1] - a[0];
            int bdis = b[1] - b[0];
            return adis == bdis ? a[0] - b[0] : (adis - bdis);
        });

        return list.get(0);
    }
}



