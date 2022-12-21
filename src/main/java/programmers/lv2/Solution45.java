package main.java.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

// LV2 연속 부분 수열 합의 개수
public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        solution45.solution(new int[]{7,9,1,1,4});
    }

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int start = 1;
        while(start < elements.length){
            for (int i = 0; i < elements.length; i++){
                int value = 0;
                for (int j = i; j < i+start; j++){
                    value += elements[j%elements.length];
                }
                set.add(value);
            }
            start++;
        }

        int sum = 0;
        for (int i = 0; i < elements.length; i++)
            sum += elements[i];

        set.add(sum);

        return set.size();
    }

}


