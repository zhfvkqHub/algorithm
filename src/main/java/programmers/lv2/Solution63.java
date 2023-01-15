package main.java.programmers.lv2;

import java.util.*;

// LV2 롤케이크 자르기
public class Solution63 {

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        solution63.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<topping.length; i++) {

            if (map.containsKey(topping[i])) {
                int temp = map.get(topping[i]);
                map.put(topping[i], temp+1);
            } else {
                map.put(topping[i], 1);
            }

        }

        for (int i=0; i<topping.length-1; i++) {

            set.add(topping[i]);
            int temp = map.get(topping[i]);
            if (temp == 1) {
                map.remove(topping[i]);
            } else {
                map.put(topping[i], temp-1);
            }
            answer += set.size() == map.size() ? 1 : 0;

        }

        return answer;
    }
}


