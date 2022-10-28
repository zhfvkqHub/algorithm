package main.java.baekjoon;

import java.io.IOException;
import java.util.Scanner;

// 바둑이 승차(DFS) => 부분집합 태운다, 안태운다
public class Solution8 {

    static int answer = Integer.MIN_VALUE, c,n;
    static void DFS(int L, int sum, int[] arr) {
        if(sum > c) return;
        if(L==n){
            answer = Math.max(answer, sum);
        }else{
            DFS(L+1, sum+arr[L], arr); // 태운다
            DFS(L+1, sum, arr); // 안태운다
        }
    }

   public static void main(String args[]) throws IOException {
       Scanner sc = new Scanner(System.in);
       c = sc.nextInt(); // 무게
       n = sc.nextInt(); // 바둑이 마리수
        
       int[] arr = new int[n];
       for(int i=0; i<n; i++){
           arr[i] = sc.nextInt();
       }
       DFS(0,0,arr);
       System.out.println(answer);
   }



}
