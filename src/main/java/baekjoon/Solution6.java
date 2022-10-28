package main.java.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 회의실 배정 => 빨리 끝나는 회의 순 정렬
public class Solution6 {

    static class Meeting implements Comparable<Meeting>{
        int st, en;

        public Meeting(int st, int en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public int compareTo(Meeting o) {
//            return this.en - o.en; // 오름차순 정렬
            if(this.en == o.en) return this.st - o.st; // 끝나는 시간이 같으면 시작 시작으로 오름차순 정렬
            else return this.en - o.en;
        }
    }

   public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Meeting> arr = new ArrayList<>();
        for(int i =0; i<n; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            arr.add(new Meeting(st,en));
        }
       System.out.println(solution(arr,n));
   }

    private static int solution(ArrayList<Meeting> arr, int n) {
        int cnt = 0;
        Collections.sort(arr); // compareTo를 이용한 오름차순 정렬
        int maxEnd = Integer.MIN_VALUE;

        for(Meeting a : arr){
            if(maxEnd<=a.st){
                maxEnd = a.en;
                cnt++;
            }
//            if(a.st == a.en) cnt++;
//            else{
//                if(maxEnd<=a.st){
//                    maxEnd = a.en;
//                    cnt++;
//                }
//            }
        }

        return cnt;
    }

}
