package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

// LV2 2018 KAKAO BLIND RECRUITMENT > [1차] 캐시
public class Solution49 {

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        solution49.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
    }

    public int solution(int cacheSize, String[] cities) {
        int time = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {

            boolean hit = ((LinkedList<String>) queue).removeFirstOccurrence(cities[i].toUpperCase());
            queue.add(cities[i].toUpperCase());
            time++;

            if (!hit) {
                time += 4;
                if (queue.size() > cacheSize) {
                    ((LinkedList<String>) queue).removeFirst();
                }
            }

        }
        return time;
    }


}


