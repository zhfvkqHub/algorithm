package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

// 무인도 여행
public class Solution79 {

    public static void main(String[] args) {
        Solution79 Solution79 = new Solution79();
        Solution79.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
    }

    int[][] map;

    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<maps.length;i++) {
            int idx = 0;
            String[] mapSplit = maps[i].split("");

            for(String m : mapSplit) {
                map[i][idx++] = m.equals("X") ? 0 : Integer.parseInt(m);
            }
        }

        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                int total = dfs(i, j);
                if(total > 0) list.add(total);
            }
        }

        if(list.size() == 0)
            return new int[]{-1};
        else {
            Collections.sort(list);
            int[] answer = new int[list.size()];

            for(int i=0;i<list.size();i++)
                answer[i] = list.get(i);

            return answer;
        }
    }

    int dfs(int i, int j) {

        if(i < 0 || i == map.length || j < 0 || j == map[0].length) // 지도를 벗어남
            return 0;
        else if(map[i][j] == 0) // 바다 또는 이미 식량 계산 완료
            return 0;

        int food = map[i][j];
        map[i][j] = 0;

        return food + dfs(i+1, j) + dfs(i-1, j) + dfs(i, j-1) + dfs(i, j+1);
    }
}


