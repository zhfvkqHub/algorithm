package main.java.programmers.lv2;

import java.util.Arrays;

// LV2 가장 큰 수
public class Solution37 {

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        solution37.solution(new int[]{6,10,2});
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, (a, b) -> (b+a).compareTo(a+b));

        if ("0".equals(str[0]))
            return "0";

        for(String s: str)
            answer += s;

        return answer;
    }

}


