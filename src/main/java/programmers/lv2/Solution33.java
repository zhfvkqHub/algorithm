package main.java.programmers.lv2;

import java.util.*;

// LV2 소수 찾기
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        solution33.solution("17");
    }

    public static Set<Integer> set = new HashSet<Integer>();
    public static int max = 0;

    public static int solution(String numbers) {

        int answer = 0;
        char[] numArr = numbers.toCharArray();
        int len = numArr.length;
        int[] combArr = new int[len];

        for(int i = 1; i < len+1; i++) {
            combination(combArr, len, i, 0, 0, numArr);
        }

        boolean[] prime = new boolean[max+1];
        Arrays.fill(prime, Boolean.TRUE);

        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i <= max; i++) {
            if(prime[i]) {
                for( int k = 2; k <= max/i;k++) {
                    prime[k*i] = false;
                }
            }
        }

        Iterator<Integer> check = set.iterator();
        while(check.hasNext()) {
            if(prime[check.next()]) answer++;
        }

        return answer;
    }

    public static void combination(int[] combArr, int length, int r, int index, int target, char[] arr){
        char[] temp;
        if(r == 0){
            temp = new char[index];
            for(int i=0; i<index; i++) temp[i] = arr[combArr[i]];
            perm(temp,0,index,index);
        }else if(target == length) return;
        else{
            combArr[index] = target;
            combination(combArr, length, r-1, index+1, target+1, arr);
            combination(combArr, length, r, index, target+1, arr);
        }
    }
    public static void perm(char[] arr, int depth, int n, int k) {
        if (depth == k) {
            print(arr,k);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(char[] arr, int k) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                str.append(arr[i]);
                max = Math.max(max, Integer.parseInt(str.toString()));
                set.add(Integer.parseInt(str.toString()));
            }
            else
                str.append(arr[i]);
        }
    }
}


