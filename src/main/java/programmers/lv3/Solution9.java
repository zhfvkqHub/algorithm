package main.java.programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속카메라
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=java
 */
public class Solution9 {

    public static void main(String[] args) {
        Solution9 Solution8 = new Solution9();
        Solution8.solution(new int[][]{{-20,-15},{-14,-5}, {-18,-13},{-5,-3}});
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int answer = 0;

        int lastCamera = Integer.MIN_VALUE;

        for (int[] a : routes) {

            if (lastCamera < a[0]) {
                ++ answer;
                lastCamera = a[1];
            }
        }
        return answer;
    }

}



