package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LV2 귤 고르기
public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        solution39.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key : list){
            k -= map.get(key);
            answer++;

            if(k <= 0) break;
        }

        return answer;
    }

}


