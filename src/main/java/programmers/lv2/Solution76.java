package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

// 우박수열 정적분
public class Solution76 {

    public static void main(String[] args) {
        Solution76 Solution76 = new Solution76();
        Solution76.solution(5, new int[][]{{0,0},{0,-1},{2,-3},{3,-3}});
    }

    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        list.add(k);

        while(k > 1) {
            if(k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            list.add(k);
        }

        List<Double> list2 = new ArrayList<>();

        for(int i = 0; i < list.size() - 1; i++) {
            double val = ((double) list.get(i) + list.get(i + 1)) / 2;
            list2.add(val);
        }

        double[] answer = new double[ranges.length];
        int n = 0;
        double sum = 0;

        for(int[] arr : ranges) {
            if(arr[0] > list2.size() + arr[1]) {
                answer[n++] = -1.0;
                continue;
            }
            for(int j = arr[0]; j < list2.size() + arr[1]; j++) {
                sum += list2.get(j);
            }
            answer[n++] = sum;
            sum = 0;
        }

        return answer;
    }

}


