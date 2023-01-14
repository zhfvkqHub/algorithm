package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LV2 숫자 카드 나누기
public class Solution62 {
    static List<Integer> list;

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        solution62.solution(new int[]{10, 17}, new int[]{5, 20});
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        list = new ArrayList<>();
        int a = getNum(arrayA, arrayB);
        list.clear();
        int b = getNum(arrayB, arrayA);

        answer = Math.max(a, b);
        return answer;
    }

    private static int getNum(int[] arr, int[] arr2) {
        int answer = 0;

        for(int i=1; i<=arr[arr.length-1]; i++) {
            int cnt = 0;

            for(int j=0; j<arr.length; j++) {
                if(arr[j] % i == 0) {
                    cnt++;
                } else break;
            }
            if (cnt == arr.length) list.add(i);

        }

        for(int i=0; i<list.size(); i++) {
            int cnt = 0;

            for(int j=0; j<arr2.length; j++) {
                if(arr2[j] % list.get(i) != 0) {
                    cnt++;
                } else break;

            }
            if(cnt == arr2.length) answer = list.get(i);

        }
        return answer;
    }
}


