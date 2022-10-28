package main.java.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 결혼식 => 입장, 퇴장 시간을 한줄로 정렬 후 state로 구분..
public class Solution7 {

    static class Time implements Comparable<Time>{
        int time;
        char state; //온건지, 간건지

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if(this.time == o.time) return this.state - o.state;// 알파벳 오름차순
            else return this.time - o.time;// 시간 오름차순
        }
    }

   public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Time> arr = new ArrayList<>();
        for(int i =0; i<n; i++){
            int st = sc.nextInt();
            int en = sc.nextInt();
            arr.add(new Time(st,'s'));
            arr.add(new Time(en,'e'));
        }
       System.out.println(solution(arr,n));
   }

    private static int solution(ArrayList<Time> arr, int n) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr); // compareTo를 이용한 오름차순 정렬

        int cnt=0;
        for(Time a : arr){
            if(a.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer,cnt);
        }
        return answer;
    }

}
