package main.java.programmers.lv2;

import java.util.Arrays;

// Greedy(탐욕법) > 구명보트
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        solution9.solution(new int[]{70, 50, 80, 50}, 100);

    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }

        return people.length - i;
    }

}
