package main.java.programmers.lv2;

import java.util.TreeMap;

// LV2 시소 짝꿍
public class Solution71 {

    public static void main(String[] args) {
        Solution71 Solution71 = new Solution71();
        Solution71.solution(new int[]{100,180,360,100,270});
    }

    public long solution(int[] weights) {
        long answer = 0;
        TreeMap<Long, Long> map = new TreeMap<>();

        for (long w : weights)
            map.put(w, map.getOrDefault(w, 0L) + 1);

        Long[] keys = map.keySet().stream().toArray(Long[]::new);
        int len = keys.length;

        for (int i = 0; i < len; i++) {
            long a = keys[i];
            if (map.get(a) > 1) {
                answer += map.get(a) * (map.get(a) - 1) / 2;
            }

            for (int j = i + 1; j < len; j++) {
                long b = keys[j];
                if (a == b || a * 3 == b * 2 || a * 2 == b || a * 4 == b * 3)
                    answer += map.get(a) * map.get(b);
            }
        }

        return answer;
    }
}


