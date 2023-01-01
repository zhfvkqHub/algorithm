package main.java.programmers.lv2;

import java.util.HashMap;

// LV2 위장
public class Solution53 {

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        solution53.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}});
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }else{
                map.put(clothes[i][1], 1);
            }
        }

        for (int i = 0 ; i < clothes.length ; i++) {
            answer *= (map.get(clothes[i][1]) + 1);
            map.put(clothes[i][1], 0);
        }
        return answer - 1;
    }
}


