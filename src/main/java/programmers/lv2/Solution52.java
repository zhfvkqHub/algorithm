package main.java.programmers.lv2;

import java.util.ArrayList;

// LV2 하노이의 탑
public class Solution52 {

    public static int [][] arr;
    public static ArrayList<int[]> arrList;

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        solution52.solution(2);
    }

    public int[][] solution(int n) {
        arrList = new ArrayList<>();

        hanoi(n, 1, 2, 3);

        arr = arrList.stream()
                .toArray(int[][] :: new);

        return arr;
    }

    public static void hanoi(int n, int start, int mid, int end){

        if(n==1){
            arrList.add(new int[]{start,end});
            return;
        }

        hanoi(n-1, start, end, mid);
        arrList.add(new int[]{start, end});
        hanoi(n-1, mid, start, end);

    }
}


