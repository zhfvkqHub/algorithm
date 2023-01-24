package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

// LV2 n^2 배열 자르기
public class Solution69 {

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        solution69.solution(3,2,5);
    }

    public Integer[] solution(int n, long left, long right) {

        List<Integer> list = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            long mock = i / n;
            long remainder = i % n;

            int c =(int) Math.max(mock, remainder);
            c++;
            list.add(c);
        }

        return list.toArray(new Integer[0]);
    }
}


