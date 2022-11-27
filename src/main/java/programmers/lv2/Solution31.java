package main.java.programmers.lv2;

import java.util.Arrays;

// LV2 2개 이하로 다른 비트
public class Solution31 {

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        solution31.solution(new long[]{2,7});
    }

    public long[] solution(long[] numbers) {

        int N = numbers.length;

        long[] answer = new long[N];

        for(int i = 0; i < N; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {

                String s = Long.toString(numbers[i], 2);
                int zeroIdx = s.lastIndexOf("0");

                if(zeroIdx != -1) {
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx+2);
                    answer[i] = Long.parseLong(s, 2);
                } else {
                    s = "10" + s.substring(1);
                    answer[i] = Long.parseLong(s, 2);
                }

            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

