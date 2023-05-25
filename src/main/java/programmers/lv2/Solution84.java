package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 광물 캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=java
 */
public class Solution84 {

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        solution84.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
    }

    static ArrayList<String> stress = new ArrayList<>(Arrays.asList("diamond", "iron", "stone"));
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {

        DFS(picks, minerals, 0, 0);
        return answer;
    }

    private static void DFS(int[] picks, String[] minerals, int idx, int result) {
        int len = minerals.length;
        int re;

        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = Math.min(answer, result);
            return;
        }

        for (int i = 0; i < 3; i++) {
            re = result;
            if (picks[i] > 0) {
                for (int j = 0; j < 5; j++) {
                    if (idx + j < len) {
                        int findIdx = stress.indexOf(minerals[idx + j]);
                        if (i >= findIdx)
                            re += Math.pow(5, i - findIdx);
                        else
                            re++;
                    } else {
                        answer = Math.min(answer,re);
                        return;
                    }
                }

                picks[i]--;
                DFS(picks, minerals, idx + 5, re);
                picks[i]++;
            }
        }
    }
}



