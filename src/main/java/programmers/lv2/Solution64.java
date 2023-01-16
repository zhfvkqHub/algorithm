package main.java.programmers.lv2;

import java.util.*;

// LV2 테이블 해시 함수
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();
        solution64.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}},2,2,3);
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] != o2[col - 1]){
                // 오름 차순
                return o1[col - 1] - o2[col - 1];
            }else{
                // 내림 차순
                return o2[0] - o1[0];
            }
        });

        int[] sum = new int[data.length];

        for (int i=0; i < data.length; i++) {
            for (int j=0; j<data[0].length; j++){
                sum[i] += (data[i][j] % (i+1));
            }
        }

        for (int i=row_begin-1; i<row_end; i++) {
            answer =  answer ^ sum[i];
        }

        return answer;
    }
}


