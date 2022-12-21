package main.java.programmers.lv2;

import java.util.Arrays;

// LV2 H-Index
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution45 = new Solution46();
        solution45.solution(new int[]{7,9,1,1,4});
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }

        return answer;
    }

}


