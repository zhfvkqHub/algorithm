package main.java.programmers.lv2;

import java.util.Arrays;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */
public class Solution86 {

    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        solution86.solution(new int[]{6, 10, 2});
    }

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, (a, b) -> (b+a).compareTo(a+b));

        if ("0".equals(str[0]))
            return "0";

        for(String s: str)
            answer.append(s);

        return answer.toString();
    }
}



