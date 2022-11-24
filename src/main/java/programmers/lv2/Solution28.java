package main.java.programmers.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// LV2 주차 요금 계산
public class Solution28 {

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        solution28.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }

    public int[] solution(int[] fees, String[] records) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int exit = 23 * 60 + 59;
        int baseTime = fees[0], baseFee= fees[1], fee = fees[3];
        double time = fees[2];

        for(String r : records){

            int carNum = Integer.valueOf(r.substring(6, 10));
            int min = Integer.valueOf(r.substring(3,5))
                    + Integer.valueOf(r.substring(0,2)) * 60;

            if(r.charAt(11) == 'I'){
                map1.put(carNum, min);
            }else{
                int ent = map1.get(carNum);
                map2.put(carNum, map2.getOrDefault(carNum, 0) + min - ent);
                map1.remove(carNum);
            }

        }

        for(int key : map1.keySet())
            map2.put(key, map2.getOrDefault(key, 0) + exit - map1.get(key));

        for(int key : map2.keySet())
            pq.add(key);

        int[] ans = new int[map2.size()];

        for(int i = 0; i < ans.length; i ++){
            int overTime = map2.get(pq.poll()) - baseTime;
            if(overTime < 0) overTime = 0;
            ans[i] = baseFee + (int)Math.ceil(overTime / time) * fee;
        }

        return ans;
    }
}

